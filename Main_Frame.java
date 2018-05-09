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
		setTitle("������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		JMenuBar bar=new JMenuBar();
		JMenu start_menu=new JMenu("��ʼ");
		bar.add(start_menu);
		JMenu operate=new JMenu("����");
		JMenuItem add=new JMenuItem("����");
		JMenuItem delete=new JMenuItem("ɾ��");
		JMenuItem modify=new JMenuItem("�޸�");
		JMenuItem query=new JMenuItem("��ѯ");
		JMenuItem quit=new JMenuItem("�˳�");
		JMenu connect=new JMenu("����");
		JMenuItem local=new JMenuItem("����");
		//local�˵�����Ӽ�����
		local.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showInputDialog(Main_Frame.this,"������ֵ","�����ļ�");
			}
			
		});
		JMenuItem remote=new JMenuItem("Զ��");
		connect.add(local);
		connect.add(remote);
		start_menu.add(connect);
		//����˳��ļ�����
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
		insert_frame.setTitle("�������");
		insert_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		start_menu.add(operate);
		start_menu.addSeparator();
		start_menu.add(quit);
		
		//��Ӳ˵���
		add(bar,BorderLayout.NORTH);
		setSize(400,100);
	}
}
