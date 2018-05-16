package Win_SQL;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InitDialog extends JDialog{
	public InitDialog(JFrame father){
		super(father,"创建连接",true);
		add(new JLabel("this is just a test"));
		JButton ok=new JButton("ok");
		add(ok,BorderLayout.SOUTH);
		//添加ok按钮的监听器
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		
		});
		//添加中心面板，显示标签和输入框
		JPanel center_pane=new JPanel();
		add(center_pane,BorderLayout.CENTER);
		//设置中心面板的布局
		center_pane.setLayout(new GridLayout(2,5));
		String name[]={"Driver:","host:","username:","password:","DB_name:"};
		//在中心面板上添加控件
		for (int i=0;i<5;i++){
			center_pane.add(new JLabel(name[i]));
			center_pane.add(new JTextField(10));
		}
			
	}
}
 