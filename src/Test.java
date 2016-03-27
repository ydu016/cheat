import java.io.IOException;
import java.util.ArrayList;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
//import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;

import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;

import User32.*;

public class Test {
	
	final static User32 user32 = User32.INSTANCE;
	static ArrayList<Farmer> list = new ArrayList<Farmer>();
	
	public static boolean isUnique(HWND handle){
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getHandle().getHandle().toString().equals( handle.toString())){
				return false;
			}
		}
		return true;
	}
	
	public static void shushu(){

        user32.EnumWindows(new WNDENUMPROC() {

			@Override
			public boolean callback(HWND arg0, Pointer arg1) {
		        char[] windowText = new char[512];
		        user32.GetWindowText(arg0, windowText, 512);
		        String wText = Native.toString(windowText);
		        //if(wText.equals("ÃÎ»ÃÖïÏÉ2[2.140.11258.3388]") && isUnique()){
		        	//add
		        //}
                return true;
			}
			
        }, null);
	}
	
	public static void shushu2(WNDENUMPROC x){

        user32.EnumWindows(x,null);
	}
	
	public static void main(String[] args) throws InterruptedException, IOException{
		Main.openClient();
		
		while(list.size() < 5){
			
			shushu2(
				new WNDENUMPROC() {
					@Override
					public boolean callback(HWND arg0, Pointer arg1) {
				        char[] windowText = new char[512];
				        user32.GetWindowText(arg0, windowText, 512);
				        String wText = Native.toString(windowText);
				        if(wText.equals("ÃÎ»ÃÖïÏÉ2[2.140.11258.3388]") && isUnique(arg0) && list.size() < 5){
				        //if(wText.contains("ÃÎ»ÃÖïÏÉ")){
				        	MyHWND a = new MyHWND(arg0);
				        	try {
				        		System.out.println(wText);
								list.add(new Farmer(a));								
								Main.openClient();
							} catch (Exception e) {
								e.printStackTrace();
							}

				        }
		                return true;
					}
					
		        }
				
				);
			Thread.sleep(1000);
		}
		System.out.println(list.get(0).getHandle().getHandle());
		System.out.println(list.get(1).getHandle().getHandle());
		Thread.sleep(10000);
		System.out.println(list.get(0).getHandle().getHandle());
		System.out.println(list.get(1).getHandle().getHandle());
		//System.out.println(list.get(4).getHandle().getHandle());
	}
}
