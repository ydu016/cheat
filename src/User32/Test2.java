package User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;


public class Test2 {
	
	protected static User32 USER32INST = User32.INSTANCE;
	public static void main(String[] args){
		
	}
	
    public static RECT getRect(HWND hwnd)
    {
        RECT r = new RECT();
        USER32INST.GetWindowRect(hwnd, r);
        System.out.println(r.bottom);
        System.out.println(r.top);
        System.out.println(r.left);
        System.out.println(r.right);
        return r;
    }
    
}
