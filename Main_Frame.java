package Win_SQL;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Main_Frame extends JFrame{
	private JFrame insert_frame;
	public Main_Frame(){
		setTitle("主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		JMenuBar bar=new JMenuBar();
		JMenu start_menu=new JMenu("开始");
		bar.add(start_menu);
		JMenu operate=new JMenu("操作");
		JMenuItem add=new JMenuItem("增加");
		JMenuItem delete=new JMenuItem("删除");
		JMenuItem modify=new JMenuItem("修改");
		JMenuItem query=new JMenuItem("查询");
		JMenuItem quit=new JMenuItem("退出");
		JMenu connect=new JMenu("连接");
		JMenuItem local=new JMenuItem("本地");
		//local菜单项添加监听器
		local.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showInputDialog(Main_Frame.this,"请输入值","配置文件");
			}
			
		});
		JMenuItem remote=new JMenuItem("远程");
		connect.add(local);
		connect.add(remote);
		start_menu.add(connect);
		//添加退出的监听器
		quit.addActionListener(new ActionListener(
				){

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.exit(0);
					}});
		operate.add(add);
		operate.add(delete);
		operate.add(modify);
		operate.add(query);
		insert_frame=new MyFrame();
		insert_frame.setTitle("插入操作");
		insert_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start_menu.add(operate);
		start_menu.addSeparator();
		start_menu.add(quit);
		
		//添加菜单栏
		add(bar,BorderLayout.NORTH);
		setSize(400,100);
	}
}
