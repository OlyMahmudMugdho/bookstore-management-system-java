package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.conn.DBConnection;
import com.entity.User;

public class UserDAO {
	private final String CREATE_USER_QUERY = "INSERT INTO userlist(Name, DOB, Phone, Email, JoiningDate, Role, Address, Password) VALUES(?,?,?,?,?,?,?,?);";
	private final String GET_USER_QUERY = "SELECT phone,email,\"password\"  from userlist where \"password\" = ? and (phone = ? or email = ?);";
	private final String CHECK_USER_QUERY = "select * from userlist where ((phone = ?) or (email = ?) );";

	public int createUser(User user) {

		try {
			Connection conn = DBConnection.connect();
			PreparedStatement ps = conn.prepareStatement(CREATE_USER_QUERY);
			ps.setString(1, user.getName());
			ps.setString(2, (user.getDob() == null) ? " " : user.getDob());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getEmail());
			ps.setString(5, (user.getJoiningDate() == null) ? " " : user.getJoiningDate());
			ps.setString(6, (user.getRole() == null) ? " " : user.getRole());
			ps.setString(7, (user.getAddress() == null) ? " " : user.getAddress());
			ps.setString(8, user.getPassword());
			int isExecuted = ps.executeUpdate();
			System.out.println(isExecuted);
			return isExecuted;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean loginUser(User user) {
		String phone = null;
		String email = null;
		String password = null;
		try {
			Connection conn = DBConnection.connect();
			PreparedStatement ps = conn.prepareStatement(GET_USER_QUERY);
			ps.setString(1, user.getPassword());
			ps.setString(2, (user.getPhone() == null) ? " " : user.getPhone());
			ps.setString(3, (user.getEmail() == null) ? " " : user.getEmail());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				phone = rs.getString(1);
				email = rs.getString(2);
				password = rs.getString(3);
			}

			boolean matched = (phone.equals(user.getPhone()) || email.equals(user.getEmail()))
					&& (password.equals(user.getPassword()));

			if (matched) {
				return true;
			}
			return false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkAlreadyExist(User user) {
		try {
			Connection conn = DBConnection.connect();
			PreparedStatement ps = conn.prepareStatement(CHECK_USER_QUERY);
			ps.setString(1, (user.getPhone() == null) ? " " : user.getPhone());
			ps.setString(2, (user.getEmail() == null) ? " " : user.getEmail());
			
			ResultSet rs = ps.executeQuery();
			if(rs.wasNull()) {
				return false;
			}
			else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
