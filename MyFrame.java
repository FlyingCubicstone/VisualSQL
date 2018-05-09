package Win_SQL;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	private JTextField id_t;
	
	private JTextField name_t;
	
	private JTextField attack_t;

	private JTextField defend_t;

	private JTextField sex_t;
	
	private JTextField nationality_t;
	public MyFrame(){
		setSize(200,300);
		setLayout(new GridBagLayout());
		//��������ӱ�ǩ���ı���
		JLabel id=new JLabel("id:");
		id_t =new JTextField(6);
		JLabel name=new JLabel("name:");
		name_t =new JTextField(6);
		JLabel attack=new JLabel("attack:");
		attack_t =new JTextField(6);
		JLabel defend=new JLabel("defend:");
		defend_t =new JTextField(6);
		JLabel sex=new JLabel("sex:");
		sex_t =new JTextField(6);
		JLabel nationality=new JLabel("nation:");
		nationality_t =new JTextField(6);
		add(id,new GBC(0,0).setAnchor(GBC.WEST));
		add(id_t,new GBC(1,0).setWeigth(100,100).setFill(GBC.CENTER));
		add(name,new GBC(0,1).setAnchor(GBC.WEST));
		add(name_t,new GBC(1,1).setWeigth(100,100).setFill(GBC.CENTER));
		add(attack,new GBC(0,2).setAnchor(GBC.WEST));
		add(attack_t,new GBC(1,2).setWeigth(100,100).setFill(GBC.CENTER));
		add(defend,new GBC(0,3).setAnchor(GBC.WEST));
		add(defend_t,new GBC(1,3).setWeigth(100,100).setFill(GBC.CENTER));
		add(sex,new GBC(0,4).setAnchor(GBC.WEST));
		add(sex_t,new GBC(1,4).setWeigth(100,100).setFill(GBC.CENTER));
		add(nationality,new GBC(0,5).setAnchor(GBC.WEST));
		add(nationality_t,new GBC(1,5).setWeigth(100,100).setFill(GBC.CENTER));
		JButton bt=new JButton("ȷ��");//����ȷ����ť
		//���ȷ����ť�ļ�����
		bt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				boolean error=false;
				try {
					
					PreparedStatement pst;
				
					con=getConnection();
					//Ԥ�������
					pst=con.prepareStatement("insert into sanguo(id,name,gongji,fangyu,sex,country) values(?,?,?,?,?,?)");
				
					pst.setInt(1,Integer.parseInt(id_t.getText()));
					
					pst.setString(2,name_t.getText());
					
					pst.setInt(3,Integer.parseInt(attack_t.getText()));
					
					pst.setInt(4,Integer.parseInt(defend_t.getText()));
					
					pst.setString(5,sex_t.getText());
					
					pst.setString(6,nationality_t.getText());
					
					pst.execute();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(MyFrame.this,"SQL����","SQLError",2);
					error=true;
				}
				catch (NumberFormatException e1){
					JOptionPane.showMessageDialog(MyFrame.this,"���벻�Ϸ�","InputError",2);
					error=true;
				}
				finally{
					//�ر�����
					try {
						con.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(MyFrame.this,"�ļ�δ��ȷ�ر�","FileCloseError",2);
					}
					if (error==false)
					JOptionPane.showMessageDialog(MyFrame.this,"����ɹ�","SQLError",2);
					
				}
				error=false;
			}
			
		});
		
		add(bt,new GBC(0,6).setAnchor(GBC.EAST).setFill(GBC.CENTER));//���ȷ����ť
		JButton bts=new JButton("���");//������ť
		//��Ӱ�ť�ļ����������ı����ڵ��������
		bts.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				id_t.setText("");
				
				name_t.setText("");;
				
				attack_t.setText("");;

				defend_t.setText("");;

				sex_t.setText("");;
				
				nationality_t.setText("");;
			}
			
		});
		add(bts,new GBC(1,6).setAnchor(GBC.EAST).setFill(GBC.CENTER));//��������ť
	}
	//��ȡ���ݿ����ӵĺ���
	public static Connection getConnection()throws SQLException{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MOSHOU","root","123456");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"�޷��ҵ��࣡","SQLError",2);
		}
		return con;
	
	}
}
