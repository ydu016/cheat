

/**
 * Auto Generated Java Class.
 */
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.*;
import java.util.Date;
import java.io.*;
import java.lang.Long;

public class Cat {

  Robot r;
  
  public void keyClick(char c){
    
    if(c == 'a'){
      r.keyPress(KeyEvent.VK_A);
      r.keyRelease(KeyEvent.VK_A);
    } else if(c == 's'){
      r.keyPress(KeyEvent.VK_S);
      r.keyRelease(KeyEvent.VK_S);;
    } else if(c == 'd'){
      r.keyPress(KeyEvent.VK_D);
      r.keyRelease(KeyEvent.VK_D);
    } else if(c == 'f'){
      r.keyPress(KeyEvent.VK_F);
      r.keyRelease(KeyEvent.VK_F);
    } else if(c == 'j'){
      r.keyPress(KeyEvent.VK_J);
      r.keyRelease(KeyEvent.VK_J);
    } else if(c == 'k'){
      r.keyPress(KeyEvent.VK_K);
      r.keyRelease(KeyEvent.VK_K);
    } else if(c == 'l'){
      r.keyPress(KeyEvent.VK_L);
      r.keyRelease(KeyEvent.VK_L);      
    } else if(c == 'i'){
      r.keyPress(KeyEvent.VK_I);
      r.keyRelease(KeyEvent.VK_I);      
    } else if(c == 'n'){
      r.keyPress(KeyEvent.VK_N);
      r.keyRelease(KeyEvent.VK_N);     
    } else if(c == 'c'){
      r.keyPress(KeyEvent.VK_C);
      r.keyRelease(KeyEvent.VK_C);     
    } else if(c == 'h'){
      r.keyPress(KeyEvent.VK_H);
      r.keyRelease(KeyEvent.VK_H);      
    } else if(c == 'g'){
      r.keyPress(KeyEvent.VK_G);
      r.keyRelease(KeyEvent.VK_G);      
    } else if(c == 'r'){
      r.keyPress(KeyEvent.VK_R);
      r.keyRelease(KeyEvent.VK_R);         
    } else if(c == 'x'){
      r.keyPress(KeyEvent.VK_X);
      r.keyRelease(KeyEvent.VK_X);  
    } else if(c == 'o'){
      r.keyPress(KeyEvent.VK_O);
      r.keyRelease(KeyEvent.VK_O);     
    } else if(c == 'q'){
      r.keyPress(KeyEvent.VK_Q);
      r.keyRelease(KeyEvent.VK_Q); 
    } else if(c == 'u'){
      r.keyPress(KeyEvent.VK_U);
      r.keyRelease(KeyEvent.VK_U);     
    } else if(c == '0'){
      r.keyPress(KeyEvent.VK_0);
      r.keyRelease(KeyEvent.VK_0);
    } else if(c == '1'){
      r.keyPress(KeyEvent.VK_1);
      r.keyRelease(KeyEvent.VK_1);
    } else if(c == '2'){
      r.keyPress(KeyEvent.VK_2);
      r.keyRelease(KeyEvent.VK_2);
    } else if(c == '3'){
      r.keyPress(KeyEvent.VK_3);
      r.keyRelease(KeyEvent.VK_3);
    } else if(c == '4'){
      r.keyPress(KeyEvent.VK_4);
      r.keyRelease(KeyEvent.VK_4);      
    } else if(c == '5'){
      r.keyPress(KeyEvent.VK_5);
      r.keyRelease(KeyEvent.VK_5);      
    } else if(c == '6'){
      r.keyPress(KeyEvent.VK_6);
      r.keyRelease(KeyEvent.VK_6);      
    } else if(c == '7'){
      r.keyPress(KeyEvent.VK_7);
      r.keyRelease(KeyEvent.VK_7);      
    } else if(c == '8'){
      r.keyPress(KeyEvent.VK_8);
      r.keyRelease(KeyEvent.VK_8);      
    } else if(c == '9'){
      r.keyPress(KeyEvent.VK_9);
      r.keyRelease(KeyEvent.VK_9);      
    } else {}
    r.delay(250);
    
  }
  
  public void mouseClick(){
    r.mousePress(InputEvent.BUTTON1_MASK);
    r.mouseRelease(InputEvent.BUTTON1_MASK);
  }
  
  public void enterCombination(String com){
    int count = 0;
    while(count<com.length()){
      keyClick(com.charAt(count));
      count++;
    }
  }
  
  public void init(){
    int count = 0;
    while(count < 10){
      r.keyPress(KeyEvent.VK_BACK_SPACE);
      r.keyRelease(KeyEvent.VK_BACK_SPACE); 
      r.delay(500);
      count++;
    }
  }
  
  public void login(String id , String pw){
    r.mouseMove(815,350);////////////////////////
    r.delay(1000);
    mouseClick();
    init();
    enterCombination(id);
    r.delay(1000);
    r.mouseMove(815,390);
    r.delay(1000);
    mouseClick();
    r.delay(1000);
    enterCombination(pw);
    r.delay(1000);
    r.mouseMove(815,450);
    mouseClick();
    r.delay(10000);
  }
  
  public String getID(int count){
    String[] ID = new String[4];
    ID[1] = "linching3";
    ID[2] = "linching4";
    ID[3] = "roxasdu";
    String id = null;
    
     if(count < 3){
       id = ID[count];
     } else {
       int temp = count - 2;
       if(temp < 10){
         id = ID[3] + "0" + temp;
       } else {
         id = ID[3] + temp;
       }
     }
     System.out.println(id);
     return id;
  }
  
  public String getPassword(int count){
    if(count == 1 || count == 2){
      return "q8466555";
    } 
    return "asdfjk";
  }
  
  public void moblize(int i,int count)throws IOException{
    


    goHome(i);
    
    r.delay(1000);
    r.mouseMove(1075,140);
    r.delay(300);
    mouseClick();
    r.delay(300);
    r.mouseMove(800,675);
    mouseClick();
    r.delay(300);
    r.mouseMove(1150,175);
    r.delay(300);
    mouseClick();
    r.delay(300);
    
    collect(r);
    quit(i);
  }
  
  public void goHome(int i){
    if(i == 1){
      r.mouseMove(450,575);
    } else if(i == 2){
      r.mouseMove(515,500);
    } else if(i == 3){
      r.mouseMove(685,475);
    } else if(i == 4){
      r.mouseMove(685,615);
    } else if(i ==	 5){
      r.mouseMove(915,575);	
    } else {
      r.mouseMove(875,500);
    }
    r.delay(1000);
    mouseClick();
    r.delay(1000);
    r.mouseMove(1200,800);
    r.delay(1000);
    mouseClick();
    r.delay(5000);
  }
  
  public void quit(int i){

	  /**
     r.delay(2000);
     r.mouseMove(1050,45); 
     r.delay(2000);
     mouseClick();
     r.mouseMove(550,525);
     r.delay(2000);
     mouseClick();
     r.delay(5000);
     
    r.mouseMove(1000,625);
    r.delay(500);
    mouseClick();
    r.mouseMove(985,575);
    r.delay(500);
    mouseClick();
    
    r.keyPress(KeyEvent.VK_ENTER);
    r.keyRelease(KeyEvent.VK_ENTER);
    r.delay(5000);
    **/
	  

	  r.mouseMove(1225, 775);
	  r.delay(500);
	  mouseClick();
	  r.delay(500);
	  r.mouseMove(1215, 730);
	  mouseClick();
	  r.delay(5000);  
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	    r.delay(3000);

    if(i == 6){
      r.delay(500);
      r.mouseMove(1300,25);
      r.delay(500);
      mouseClick();
      r.delay(2000);
    }
 
    /**
    r.delay(1000);
    r.mouseMove(225,750);
    r.delay(1000);
    r.mousePress(InputEvent.BUTTON3_MASK);
    r.mouseRelease(InputEvent.BUTTON3_MASK);
    r.delay(1000);
    r.mouseMove(225,700);
    r.delay(1000);
    r.mousePress(InputEvent.BUTTON1_MASK);
    r.mouseRelease(InputEvent.BUTTON1_MASK);
    r.delay(2000);
    r.keyPress(KeyEvent.VK_ENTER);
    r.keyRelease(KeyEvent.VK_ENTER);
    r.delay(1000);
    **/
  }
  
  public void collect(Robot r){


      
	  
	  
    r.mouseMove(300,50);
    mouseClick();
    r.delay(5000);
    
    
    r.keyPress(KeyEvent.VK_ESCAPE);
    r.keyRelease(KeyEvent.VK_ESCAPE);
    r.delay(1000);
    
    //签到

    
    r.keyPress(KeyEvent.VK_TAB);
    r.keyRelease(KeyEvent.VK_TAB); 
    r.delay(1000);
    r.mouseMove(1075,420);
    mouseClick();	
    r.delay(15000);
    r.keyPress(KeyEvent.VK_TAB);
    r.keyRelease(KeyEvent.VK_TAB);
    
    r.delay(1000);
    r.keyPress(KeyEvent.VK_ESCAPE);
    r.keyRelease(KeyEvent.VK_ESCAPE);
    r.delay(1000);
    
    r.mouseMove(750,350);//家园管理人
    r.delay(1000);
    mouseClick();
    r.delay(2000);

    r.mouseMove(600,525);
    r.delay(1000);
    mouseClick();//进入
    r.delay(3000);
    
    
    r.mouseMove(1250,650);
    r.delay(1000);
    mouseClick();//一步
    r.delay(5000);
    mouseClick();
    r.delay(5000);//二步
    
    //菜地
	  
   
    r.mouseMove(500,530);
    r.delay(1000);
    mouseClick();//一步
    r.delay(3000);

    System.out.println(1);
    //r.mouseMove(480,390);
    //r.delay(1000);
    mouseClick();
    System.out.println(1.1);
    r.delay(2000);
    //mouseClick(); System.out.println(1.2);
    //r.delay(10000);
    System.out.println(2);
    
    r.mouseMove(610,510);//羽坛
    r.delay(1000);
    mouseClick();
    r.delay(1000);
    r.mouseMove(715,455);
    r.delay(1000);
    mouseClick();
    r.delay(500);
    r.keyPress(KeyEvent.VK_ESCAPE);
    r.keyRelease(KeyEvent.VK_ESCAPE);
    r.delay(500);

    r.delay(1000);
    r.mouseMove(490,500);
    r.delay(1000);
    mouseClick();
    r.delay(1000);
    
    r.mouseMove(610,530);//收包
    r.delay(2000);
    mouseClick();
    r.delay(2000);
    
    System.out.println(3);
   
    r.mouseMove(785,545);
    r.delay(2000);
    mouseClick();
    r.delay(2000);
    
    System.out.println(4);
     
	r.mouseMove(490,500);
	    r.delay(2000);
	    mouseClick();
	    r.delay(2000);
	    r.mouseMove(610,510);//羽坛
	    r.delay(2000);
	    mouseClick();
	    r.delay(2000);
	    r.mouseMove(715,455);
	    r.delay(2000);
	    mouseClick();
	    r.delay(2000);
	    r.keyPress(KeyEvent.VK_ESCAPE);
	    r.keyRelease(KeyEvent.VK_ESCAPE);
	    r.delay(2000);



  }
  
  public void open() throws IOException{
    Runtime.getRuntime().exec("C:\\梦幻诛仙\\launcher\\launcher.exe");
    r.delay(5000);
    r.mouseMove(1100,585);///////////////////////
    r.delay(2000);
    mouseClick();
    r.delay(15000);
    r.keyPress(KeyEvent.VK_ENTER);
    r.keyRelease(KeyEvent.VK_ENTER);
    r.delay(3000);
    r.mouseMove(1100,700);
    r.delay(1000);
    mouseClick();
    r.delay(2000);
  }

  void date()throws Exception{
    
    Date date = new Date();;
    /**
    File file = new File("value.txt");;
    ObjectInputStream input=new ObjectInputStream(new FileInputStream(file));
    Object runtime = input.readObject();
    ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream(file));
    output.writeObject(System.currentTimeMillis());

    System.out.println("昨天结束："+runtime);
    System.out.println("今天开始："+System.currentTimeMillis());

    long day = 86400000;
    long toDelay = System.currentTimeMillis() - day - new Long(runtime.toString());
    System.out.println("等待："+toDelay+" 毫秒");
    int stop = (int)toDelay/60000-2;
    System.out.println("暂停系数： "+stop);
    
    stop = -60;/////////////////////

    while(stop<0){
      r.delay(60000);
      stop++;
    }

    **/
  }
  
  public void exec(){
    
    try{
      r = new Robot();
     date();


    int count = 1;//1
    int inner = 1;//1
    while(count < 15){
        open();
        login(getID(count) ,getPassword(count)); 
    while(inner < 7){
      moblize(inner,count);
      r.delay(5000);
      inner++;
    }
      r.delay(10000);
      inner = 1;
      count++;
    }
    

    System.out.println(System.currentTimeMillis());
    Runtime.getRuntime().exec("cmd /c start call shutdown -S -f -t 0");

    }catch (Exception e){
      System.out.println(e);
    }
   
     
  }
  
  public static void  main(String[] args) throws AWTException, InterruptedException{
	Cleaner c = new Cleaner();
	c.start();
    Cat cat = new Cat();
    cat.exec();

  }
  
}


