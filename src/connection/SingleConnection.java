package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:mysql://localhost:3306/sgb?autoReconnect=true";
	private static String password = "admin";
	private static String user = "root";
	private static Connection connection = null;

	static {
		
		conectar();
	}
	
	public SingleConnection() {
		
		conectar();
	}
	
	private static void conectar() {
		
		try {
			
			if(connection == null) {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
