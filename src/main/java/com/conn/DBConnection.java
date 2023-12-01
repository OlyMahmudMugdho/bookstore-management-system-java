package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static DBConnection instance;
	private static Connection conn;
	
	public static final String url = "jdbc:postgresql://localhost:5432/bookstore";
	public static final String user = "postgres";
	public static final String password = "password";
	
	private DBConnection() {
		
	}
	
	public static Connection connect() {
		try {
			if(instance == null) {
				instance = new DBConnection();
				Class.forName("org.postgresql.Driver");
				conn = DriverManager.getConnection(url, user, password);
				System.out.println("connected to database");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
