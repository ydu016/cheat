package User32;

import com.sun.jna.platform.win32.WinDef.HWND;

public class MyHWND {
	
	HWND handle;
	
	public MyHWND(){
	}
	
	public MyHWND(HWND handle){
		this.handle = handle;
	}
	
	public void setHandle(HWND handle){
		this.handle = handle;
	}
	
	public HWND getHandle(){
		return handle;
	}
	
	public boolean isNull(){
		return handle == null;
	}	
	
	public boolean equals(MyHWND handle){
		if(this.isNull()){
			return false;
		}
		return this.handle.toString().equals(handle.getHandle().toString());
	}
	
}
