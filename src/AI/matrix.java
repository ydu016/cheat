package AI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;

import javax.imageio.ImageIO;



public class matrix {
	
	static int[][] m0 = {
		{0,0,1,1,0,0},
		{0,1,0,0,1,0},
		{1,1,0,0,1,1},
		{1,1,0,0,1,1},
		{1,1,0,0,1,1},
		{1,1,0,0,1,1},
		{1,1,0,0,1,1},
		{0,1,0,0,1,0},
		{0,0,1,1,0,0},
	};
	
	public static void main(String[] args) {
		
		LinkedList<pair> list = new LinkedList<pair>();
		list.add(new pair(0,2-2));
		list.add(new pair(0,3-2));
		list.add(new pair(1,1-2));
		list.add(new pair(1,2-2));
		list.add(new pair(1,3-2));
		list.add(new pair(1,4-2));
		list.add(new pair(2,0-2));
		list.add(new pair(2,1-2));
		list.add(new pair(2,4-2));
		list.add(new pair(2,5-2));
		list.add(new pair(3,0-2));
		list.add(new pair(3,1-2));
		list.add(new pair(3,4-2));
		list.add(new pair(3,5-2));
		list.add(new pair(4,0-2));
		list.add(new pair(4,1-2));
		list.add(new pair(4,4-2));
		list.add(new pair(4,5-2));
		list.add(new pair(5,0-2));
		list.add(new pair(5,1-2));
		list.add(new pair(5,4-2));
		list.add(new pair(5,5-2));
		list.add(new pair(6,0-2));
		list.add(new pair(6,1-2));
		list.add(new pair(6,4-2));
		list.add(new pair(6,5-2));
		list.add(new pair(7,1-2));
		list.add(new pair(7,2-2));
		list.add(new pair(7,3-2));
		list.add(new pair(7,4-2));
		list.add(new pair(8,2-2));
		list.add(new pair(8,3-2));
		
		//int[] rgb = new int[3];
        File file = new File("C:/ÃÎ»ÃÖïÏÉ/screenshot/2014_12_16_10_41.bmp");
		//File file = new File("C:/ÃÎ»ÃÖïÏÉ/screenshot/zero.png");
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int width = bi.getWidth();
        int height = bi.getHeight();
        int minx = bi.getMinX();
        int miny = bi.getMinY();
        System.out.println("width=" + width + ",height=" + height + ".");
        System.out.println("minx=" + minx + ",miniy=" + miny + ".");
        
        int pixel = 0;
        double count = 0;
        
        for(int i = minx; i < height; i++) {
        	for(int j = miny; j < width; j++) {
        		
        		pixel = bi.getRGB(j, i);
        		int[] rgb = {(pixel & 0xff0000) >> 16, (pixel & 0xff00) >> 8, (pixel & 0xff) };

        		if(rgb[0] > 180 && rgb[1] > 180 && rgb[1] > 180) {
        			
        			for(int l=0; l<list.size(); l++) {
        				pair tmp = list.get(l);
        				
        				if((j+tmp.y) < 0 || (j+tmp.y) >= width || (i+tmp.x < 0) || (i+tmp.x) >= height ){
        					count += 100;
        					break;
        				}
        					//break;
        				//if(verify(j+tmp.y, i+tmp.x, bi)) {
      					//count++;
        				//}
        				count += verify(j+tmp.y, i+tmp.x, bi);
        			}
        			
        			if(count / list.size() < 0.1) {
        			//if(count / list.size() > 0.9) {
        				System.out.println(j+","+i);
        				System.out.println( count / list.size()+": "+list.size());
        				if(i == 442 && j == 508) 
        					System.out.println("real");
        			}
        		}
        		count = 0;
        	}
        }
        
        printPT(3,2,bi);
        printPT(2,3,bi);
        /**
        printPT(677,623,bi);
        printPT(678,623,bi);
        printPT(676,624,bi);
        printPT(677,624,bi);
        printPT(678,624,bi);
        printPT(679,624,bi);
        
        printPT(675,625,bi);
        printPT(676,625,bi);
        printPT(679,625,bi);
        printPT(680,625,bi);
        
        printPT(675,626,bi);
        printPT(676,626,bi);
        printPT(679,626,bi);
        printPT(680,626,bi);
        
        printPT(675,627,bi);
        printPT(676,627,bi);
        printPT(679,627,bi);
        printPT(680,627,bi);
        
        printPT(675,628,bi);
        printPT(676,628,bi);
        printPT(679,628,bi);
        printPT(680,628,bi);
        
        printPT(675,629,bi);
        printPT(676,629,bi);
        printPT(679,629,bi);
        printPT(680,629,bi);
        
        printPT(676,630,bi);
        printPT(677,630,bi);
        printPT(678,630,bi);
        printPT(679,630,bi);
        printPT(677,631,bi);
        printPT(678,631,bi);
        **/
	}
	
	static double verify(int i, int j, BufferedImage bi) {
		
		int pixel = bi.getRGB(i, j);
		int[] rgb = {(pixel & 0xff0000) >> 16, (pixel & 0xff00) >> 8, (pixel & 0xff) };
		//return rgb[0] > 150 && rgb[1] >150 && rgb[2] > 150;
		double tmp = (Math.abs(rgb[0]-255) + Math.abs(rgb[1]-255) + Math.abs(rgb[2]-255))/3.0/255.0;
		//System.out.println(tmp);
		return tmp;
	}
	
	static void printPT(int i, int j, BufferedImage bi) {
		int pixel = bi.getRGB(i, j);
		int[] rgb = {(pixel & 0xff0000) >> 16, (pixel & 0xff00) >> 8, (pixel & 0xff) };
		System.out.println("i=" + i + ",j=" + j + ":(" + rgb[0] + ","
                		+ rgb[1] + "," + rgb[2] + ")");
	}
}

