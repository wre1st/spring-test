package com.bean.aop.proxy;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection con=null;
	
	private DBConnection() {
		if (con==null) {
try {
			//			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			Connection conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa","");
//			spring.datasource.url=jdbc:sqlserver://sqlsrv\\sqlexpress;databaseName=customer
//			String dbURL = "jdbc:sqlserver://localhost\\send_email;user=sa;password=abcd@12345";
			  con = DriverManager.getConnection("jdbc:sqlserver://localhost\\send_email","sa","");
			
}catch(Exception e) {
	e.printStackTrace();
}
		}
	}
	public static Connection getConnection() {
		if(con==null) {
			new DBConnection();
		}
		return con;
	}
}
