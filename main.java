package Win_SQL;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class main {
	public static void main(String[] args){
		JFrame frame=new Main_Frame();
		Dimension size=getScreenSize();
		//屏幕的宽和高
		int loc_x=(int) size.getWidth();
		int loc_y=(int) size.getHeight();
//		窗口的宽和高
		int w_x=frame.getWidth();
		int w_y=frame.getHeight();
		//将窗体放置在正中央
		frame.setLocation(loc_x/2-w_x/2,loc_y/2-w_y/2);
		
		
	}
	//获取屏幕的分辨率
	public static Dimension getScreenSize(){
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension dimension=kit.getScreenSize();
		return dimension;
	}
}
