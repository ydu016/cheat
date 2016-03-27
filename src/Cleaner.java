import MyParam.GameParams;
import User32.*;

class Cleaner extends Thread{
	
	MyHWND err1;// = new MyHWND();
	MyHWND err2;// = new MyHWND();
	MyHWND err3;// = new MyHWND();
	
	@SuppressWarnings("static-access")
	public void run(){
		while(true){
		
			try {
				
				err1 = MyWrapper.findWindow(GameParams.err1);
				if( !err1.isNull() ){
					MyWrapper.closeWindow(err1);
				}
			
				err2 = MyWrapper.findWindow(GameParams.err2);
				if( !err2.isNull() ){
					MyWrapper.closeWindow(err2);
				}
				
				err3 = MyWrapper.findWindow(GameParams.err3);
				if( !err3.isNull() ){
					MyWrapper.closeWindow(err3);
				}
				
				this.sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
