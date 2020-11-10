package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

	public static Connection getConnection() {
		Connection con = null;
		
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("dbinfo.txt"));
			
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pw = p.getProperty("pw");
			
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, pw);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
	
	
	public static void close(Connection con, Statement st, ResultSet rs) {

			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} 
	
	}
	
	
	
	

}
