import java.io.IOException;
import java.util.concurrent.Semaphore;

import MyParam.GameParams;
import User32.*;

public class FarmerFuncs {
	
	static HandleAssigner assigner = new HandleAssigner(5);
	
	public static MyHWND openGame(int id) throws IOException, InterruptedException{
		System.out.println(id);
		System.out.println("���ڴ��λ����ɸ��³���");
		Runtime.getRuntime().exec(GameParams.gamePath);
		  
		MyHWND handle1 = new MyHWND();//������ 
		for(int i =0; i < 10 && handle1.isNull(); i++){ 
			Thread.sleep(1000); handle1 = MyWrapper.findWindow(GameParams.updaterName);
		}
		
		if(handle1.isNull()){ 
			System.out.println("���λ����ɸ��³���ʧ��");
			return null;  
		} 
		System.out.println("�λ����ɸ��³����Ѵ�");
		MyWrapper.minimize(handle1);  
		
		System.out.println("���ڼ���Ƿ���Ҫ����"); 
		MyHWND handle2 = new MyHWND();//������
		MyHWND handle3 = new MyHWND();//�и��� 
		for(int i = 0; i < 10 && handle2.isNull() && handle3.isNull(); i++){
			handle2 = MyWrapper.findWindow(handle1, GameParams.isUpdated); 
			handle3 = MyWrapper.findWindow(handle1, GameParams.notUpdated);
			Thread.sleep(1000); 
		}
		 
		if(!handle2.isNull() && handle3.isNull()){
			System.out.println(GameParams.isUpdated);	 
		}else if(handle2.isNull() && !handle3.isNull()){
			System.out.println(GameParams.notUpdated);
			System.out.println("��ʼ����"); 
			MyHWND handle4 = new MyHWND();
			
			for(int i = 0; i < 10 && handle4.isNull(); i++){ 
				handle4 = MyWrapper.findChildWindow(handle1);
				//handle4 = MyWrapper.findWindow("OpenWebPage");
				Thread.sleep(1000);
			}
			/**
			for(int i = 0; i < 10 && handle4.isNull(); i++){ 
				handle4 = MyWrapper.findWindow("Patcher"); 
				Thread.sleep(1000);
			}
			**/
			
		if(handle4.isNull()){ 
			System.out.println("����ʧ��1"); 
			return null;
		}
		
		MyWrapper.rightClick(MyWrapper.findWindow(handle4,"OK")); 
		for(int i = 0; i < 600000 && handle2.isNull();i++){ 
			handle2 = MyWrapper.findWindow(handle1, GameParams.isUpdated); Thread.sleep(1000); 
		} 
		if(handle2.isNull()){ 
			System.out.println("����ʧ��2"); 
			return null; 
		}
		System.out.println(GameParams.isUpdated);  
		}else{  
			System.out.println("������ʧ��"); 
			return null;
		}
		 
		MyWrapper.rightClick(MyWrapper.findWindow(handle1, GameParams.enter));
		
		assigner.setId(id);
		while(assigner.getHandle(id).isNull()){	
			MyWrapper.EnumWindows(assigner);
			Thread.sleep(1000);
		}
		//MyWrapper.printScreen(assigner.getHandle(id));
		//MyWrapper.minimize(assigner.getHandle(id));
		return assigner.getHandle(id);
	}
	
	public static boolean isAlive(MyHWND handle, int id) throws InterruptedException{
		HandleSeeker seeker = new HandleSeeker(handle);
		MyWrapper.EnumWindows(seeker);
		if( !seeker.isExist() ){
			assigner.getHandle(id).setHandle(null);
		}
		System.out.println("akb");
		MyWrapper.printScreen(assigner.getHandle(id));
		MyWrapper.clickA(handle);
		return seeker.isExist();
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Cleaner c = new Cleaner();
		c.start();
		
		Semaphore a = new Semaphore(1,true);
		Farmer f0 = new Farmer(a,0);
		new Thread(f0).start();
		
		
		
		//Farmer f1 = new Farmer(a,1);
		//new Thread(f1).start();
		
		//Farmer f2= new Farmer(a,2);
		//new Thread(f2).start();
		/**
		Farmer f3 = new Farmer(a,3);
		new Thread(f3).start();
		Farmer f4 = new Farmer(a,4);
		new Thread(f4).start();
		**/
		//while(true){
		//System.out.println(f0.getHandle().isAlive());
		//Thread.sleep(1000);
		//}
		
	}

}
