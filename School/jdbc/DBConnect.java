package s21217_JypJdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	static Connection getConnection(){
		Connection con;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";			
			con = DriverManager.getConnection(url, "sw212", "1234");
			return con;
		} catch (Exception e) {
			return null;
		}	
		
	}	
}
