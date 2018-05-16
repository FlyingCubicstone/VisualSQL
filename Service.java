package Win_SQL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//username:null
//passwd:null
//db_name:null
public class Service {
	//��ȡ������
	public static  Connection getConnection() throws IOException, SQLException{
		//��config.properties�ļ��ж�ȡ������Ϣ
		Properties prop=new Properties();
		File file=new File("./config.properties");
		FileInputStream fis=new FileInputStream(file);
		prop.load(fis);
		String host=prop.getProperty("host");
		String driver=prop.getProperty("driver"); 
		String username=prop.getProperty("username");
		String passwd=prop.getProperty("passwd");
		String db_name=prop.getProperty("db_name");
		String url=null;
		if (driver=="oracle.jdbc.driver.Oracle"){
			url="jdbc?:oracle:thin:@"+host+":1521:"+db_name;
		}else if (driver=="com.mysql.jdbc.Driver"){
			url="jdbc:mysql://"+host+":3306/"+db_name;
		}
		//����������
		Connection con=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,passwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot find Class");
		}
		return con;
	}
	//��ȡstatement
	public static Statement createStatement() throws IOException, SQLException{
		Statement state=getConnection().createStatement();
		return state;
	}

}
