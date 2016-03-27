package User32;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;

public class HandleAssigner implements WNDENUMPROC{

	static ArrayList<MyHWND> handleList;
	
	int id;

	public HandleAssigner(int size) {
		handleList = new ArrayList<MyHWND>(size);
		for(int i = 0; i < size; i++){
			handleList.add(new MyHWND());
		}
	}

	static protected boolean isUnique(HWND handle){		
		for(int i = 0; i < handleList.size(); i++){
			if( handleList.get(i).equals(new MyHWND(handle)) ){
				return false;
			}
		}
		return true;
	}
	
	static protected boolean isGameWindow(String title){
		return Pattern.compile("(^ÃÎ»ÃÖïÏÉ2\\[)([0-9]+\\.){3}[0-9]+(\\])$").matcher(title).matches();
	}
	
	@Override
	public boolean callback(HWND handle, Pointer ptr) {
        char[] windowText = new char[512];
        MyWrapper.USER32INST.GetWindowText(handle, windowText, 512);
        String title = Native.toString(windowText);
        if( isGameWindow(title) && isUnique(handle) ){
			Rectangle r = MyWrapper.GetWindowRect(new MyHWND(handle));
	        System.out.println("B "+r.height);
	        System.out.println("B "+r.width);
	        System.out.println("B "+r.x);
	        System.out.println("B" +r.y);
        	handleList.get(id).setHandle(handle);
			Rectangle rr = MyWrapper.GetWindowRect(handleList.get(id));
	        System.out.println("a "+rr.height);
	        System.out.println("a "+rr.width);
	        System.out.println("a "+rr.x);
	        System.out.println("a" +rr.y);
        }
        return true;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public MyHWND getHandle(int id){
		if(handleList.size() > id){
			return handleList.get(id);
		}else{
			return null;
		}
	}

}
