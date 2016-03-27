package User32;

import java.awt.Rectangle;

import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;

public class MyWrapper {
	
	final static int VK_SNAPSHOT = 0x2C;
	final static int VK_RETURN = 0x0D;
	final static int VK_C = 0x43;
	final static int VK_PRINT = 0x2A;
	
	final static int WM_KEYDOWN = 0x0100;
	final static int WM_KEYUP = 0x0101;
	final static int WM_CHAR = 0x0102;
	
	final static int WM_CAPTURECHANGED  = 0x0215;
	final static int WM_LBUTTONDBLCLK = 0x0203;
	final static int WM_LBUTTONDOWN = 0x0201;
	final static int WM_LBUTTONUP = 0x0202;
	
	final static int WM_CLOSE = 0x0010;
	
	final static int WM_SYSCOMMAND = 0x0112;
	final static int SC_MAXIMIZE = 0xF030;
	final static int SC_MINIMIZE = 0xF020;
	
	protected static User32 USER32INST = User32.INSTANCE;
		
	private static WinDef.WPARAM getWPARAM(long value){
		return new WinDef.WPARAM(Long.parseLong(String.valueOf(value)));
	}
	
	private static WinDef.LPARAM getLPARAM(long value){
		return new WinDef.LPARAM(Long.parseLong(String.valueOf(value)));
	}
	
	public static MyHWND findWindow(String name){
		MyHWND handle = new MyHWND(USER32INST.FindWindow(null, name));
		return handle;
	}
	
	public static MyHWND findWindow(MyHWND parent, String child){
		MyHWND handle = new MyHWND(USER32INST.FindWindowEx(parent.getHandle(), null, null, child));
		return handle;
	}
	
	public static MyHWND findChildWindow(MyHWND parent){
		MyHWND handle = new MyHWND(USER32INST.FindWindowEx(parent.getHandle(), null, "#32770", null));
		return handle;
	}
	
	public static Rectangle GetWindowRect(MyHWND handle){	
		WinDef.RECT rect = new WinDef.RECT();
		USER32INST.GetWindowRect(handle.getHandle(), rect);
		return rect.toRectangle();
	}
	
	public static void EnumWindows(WNDENUMPROC wndenumproc){

		USER32INST.EnumWindows(wndenumproc, null);
	}
	
	public static void printScreen(MyHWND handle) throws InterruptedException{
		Thread.sleep(500);
		USER32INST.PostMessage(handle.getHandle(), WM_CHAR, (byte)(VK_SNAPSHOT), getLPARAM(0));
		//USER32INST.PostMessage(handle.getHandle(), WM_KEYUP, (VK_SNAPSHOT), getLPARAM(0));
	}
	
	public static void clickA(MyHWND handle) throws InterruptedException{
		Thread.sleep(500);
		//USER32INST.PostMessage(handle.getHandle(), WM_CHAR, (byte)(VK_C), getLPARAM(0));
	}
	
	public static void rightClick(MyHWND handle) throws InterruptedException{
		Thread.sleep(500);
		USER32INST.PostMessage(handle.getHandle(),WM_LBUTTONDOWN, getWPARAM(0), getLPARAM(0));
		USER32INST.PostMessage(handle.getHandle(),WM_LBUTTONUP, getWPARAM(0), getLPARAM(0));
	}
	
	public static void rightClick(MyHWND handle, long x, long y) throws InterruptedException{
		Thread.sleep(500);
		USER32INST.PostMessage(handle.getHandle(), WM_LBUTTONDOWN, getWPARAM(0), getLPARAM((y<<16)+x));
		USER32INST.PostMessage(handle.getHandle(), WM_LBUTTONUP, getWPARAM(0), getLPARAM((y<<16)+x));
	}
	
	public static void closeWindow(MyHWND handle) throws InterruptedException{
		Thread.sleep(500);
		USER32INST.PostMessage(handle.getHandle(), WM_CLOSE, getWPARAM(0), getLPARAM(0));
	}
	
	public static void minimize(MyHWND handle) throws InterruptedException{
		Thread.sleep(500);
		USER32INST.SendMessage(handle.getHandle(), WM_SYSCOMMAND, SC_MINIMIZE, getLPARAM(0));
	}
	
}
