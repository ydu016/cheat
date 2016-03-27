package User32;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;

public class HandleSeeker implements WNDENUMPROC{

	private Boolean isExist;
	private MyHWND target;
	
	public HandleSeeker(MyHWND target){
		this.isExist = false;
		this.target = target;
	}
	
	@Override
	public boolean callback(HWND handle, Pointer ptr) {
        if( !target.isNull() && handle.toString().equals(target.getHandle().toString()) ){
        	isExist = true;
        }
        return true;
	}
	
	public boolean isExist(){
		return isExist;
	}

}
