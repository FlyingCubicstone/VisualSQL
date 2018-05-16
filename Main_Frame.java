package Win_SQL;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main_Frame extends JFrame{
	private JFrame insert_frame;
	private JTextArea textarea;
	private int default_width=600;
	private int default_height=400;
	private JDialog init_frame;
	public Main_Frame(){
		textarea=new JTextArea(10,20);
		textarea.setEditable(false);
		JScrollPane pane=new JScrollPane(textarea);
		add(pane,BorderLayout.CENTER);
		setTitle("VisualSQL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		JMenuBar bar=new JMenuBar();
		JMenu start_menu=new JMenu("��ʼ");
		bar.add(start_menu);
		JMenu operate=new JMenu("����");
		JMenuItem add=new JMenuItem("����");
		add.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(insert_frame==null) {
					insert_frame=new MyFrame();
					insert_frame.setLocation(200,300);
					insert_frame.setVisible(true);
				}else {
			
				}
				
			}
			
		});
		JMenuItem delete=new JMenuItem("ɾ��");
		JMenuItem modify=new JMenuItem("�޸�");
		JMenuItem query=new JMenuItem("��ѯ");
		query.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
//				Statement statement=Service.createStatement();
			
				// TODO Auto-generated method stub
//				Connection con=null;
//				try {
//					con=MyFrame.getConnection();
//					String sql=JOptionPane.showInputDialog(Main_Frame.this, "�����ѯ���");
//					Statement state=con.createStatement();
//					if (sql!="") {
//					ResultSet set=state.executeQuery(sql);
//					while (set.next()){
//						Model hero=new Model();
//						hero.setId(set.getInt("id"));
//						hero.setName(set.getString("name"));
//						hero.setAttack(set.getInt("gongji"));
//						hero.setDefend(set.getInt("fangyu"));
//						hero.setSex(set.getString("sex"));
//						hero.setCountry(set.getString("country"));
//						textarea.setText(hero.toString()+"\n"+textarea.getText());
//					}}
//					textarea.setText("");
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}finally{
//					try {
//						con.close();
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
			}
			
		}
			);
		JMenuItem quit=new JMenuItem("�˳�");
		JMenu connect=new JMenu("����");
		JMenuItem local=new JMenuItem("����");
		//local�˵�����Ӽ�����
		local.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String user=JOptionPane.showInputDialog(Main_Frame.this,"�������û���");
				String passwd=JOptionPane.showInputDialog(Main_Frame.this,"����������");
				String db_name=JOptionPane.showInputDialog(Main_Frame.this,"���������ݿ���");
				System.out.println(user+" "+passwd+" "+db_name);
				File file=new File("./config.properties");
				FileOutputStream fos=null;
				try {
					fos = new FileOutputStream(file);
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				OutputStreamWriter osw=null;
				try {
					osw=new OutputStreamWriter(fos,"utf-8");
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					osw.write("username:"+user+"\n");
					osw.write("passwd:"+passwd+"\n");
					osw.write("db_name:"+db_name);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					try {
						osw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
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
		bar.add(operate);
		start_menu.addSeparator();
		start_menu.add(quit);
		
		//��Ӳ˵���
		add(bar,BorderLayout.NORTH);
		setSize(default_width,default_height);
		pack();
	}
}
