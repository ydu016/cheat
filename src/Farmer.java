import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Semaphore;

import javax.imageio.ImageIO;

import User32.MyHWND;
import User32.MyWrapper;

public class Farmer implements Runnable{
	
	MyHWND handle;
	Semaphore run;
	int id;
	
	Farmer(Semaphore run, int id){
		handle = new MyHWND();
		this.run = run;
		this.id = id;
	}

	public MyHWND getHandle(){
		return handle;
	}
	
	@Override
	public void run() {
		
		if(handle.isNull()){
			try {
				run.acquire(1);
				handle = FarmerFuncs.openGame(id);
				run.release(1);
				//MyWrapper.minimize(handle);
				Rectangle r = MyWrapper.GetWindowRect(handle);
		        System.out.println(r.height);
		        System.out.println(r.width);
		        System.out.println(r.x);
		        System.out.println(r.y);
				
	            File f = File.createTempFile("findDiff", ".bmp");
	            System.out.println(f.getAbsolutePath());
	            // 写出位图
	            BufferedImage buffImage;
					buffImage = new Robot().createScreenCapture(r);
				
	            if (buffImage == null)
	            {
	                return;
	            }
	            ImageIO.write(buffImage, "bmp", new FileOutputStream(f));

				while(true){
								
					if(!FarmerFuncs.isAlive(handle, id)){						
						run.acquire(1);
						FarmerFuncs.openGame(id);
						run.release(1);
					}
					Thread.sleep(1000);

				}
				
			}  catch (IOException | InterruptedException | AWTException e) {
				e.printStackTrace();
			}
				
		}

	}
	

	
}
