package Win_SQL;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class main {
	public static void main(String[] args){
		JFrame frame=new Main_Frame();
	}	
	//��ȡ��Ļ�ķֱ���
	public static Dimension getScreenSize(){
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension dimension=kit.getScreenSize();
		return dimension;
	}
}
