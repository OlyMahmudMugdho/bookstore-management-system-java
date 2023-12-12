package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
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
		boolean exist = true;
		try {
			Connection conn = DBConnection.connect();
			PreparedStatement ps = conn.prepareStatement(CHECK_USER_QUERY);
			ps.setString(1, user.getPhone());
			ps.setString(2, user.getEmail());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				exist = true;
				return true;
			}
			if (!(rs.next())) {
				exist = false;
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return exist;
	}
	
	public void isAuthenticated(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tokenValue = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie ck : cookies) {
				if(ck.getName().equals("token")){
					tokenValue = ck.getValue();
				}
			}
		}
		
		if(cookies==null) {
			response.sendRedirect("index.jsp");
			return ;
		}
		
		try {
			Algorithm algorithm = Algorithm.none();
			JWTVerifier verifier = JWT.require(algorithm)
					.withIssuer("auth0")
					.build();
			DecodedJWT decodedJWT = verifier.verify(tokenValue);
			return ;
		}
		catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("logout");
			return ;
		}
	}


}
