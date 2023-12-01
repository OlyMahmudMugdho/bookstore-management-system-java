package com.servlet;

import java.sql.Connection;

import com.conn.DBConnection;

public class Home {
	public static void main(String[] args) {
		Connection conn = DBConnection.connect();
		Connection conn2 = DBConnection.connect();
		System.out.println(conn == conn2);
	}
}
