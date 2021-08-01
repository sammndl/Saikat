package com.register.util;

import java.sql.*;

public class DatabaseCon {

	public static Connection createConnection() {
		
		Connection con = null;
		
		String url = "jdbc:mysql://localhost:3306/student_info?";
		String username = "saikat";
		String password = "1781";
		
		try {
			
			Class.forName("org.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Printing Connection Object"+con);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
}
