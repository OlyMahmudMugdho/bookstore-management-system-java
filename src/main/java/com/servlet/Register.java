package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.entity.User;


@WebServlet("/register")
public class Register extends HttpServlet {
	RequestDispatcher rd;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String password = req.getParameter("password");
		
		if((name==null) | (email==null) | (phone==null) | (password==null) ) {
			PrintWriter out = resp.getWriter();
			out.print("<div class=\"alert alert-danger\">\n"
					+ "  <strong>Error!</strong> name,email,phone,password are required.\n"
					+ "</div>");
			rd = req.getRequestDispatcher("register.jsp");
			rd.include(req, resp);
			return;
		}
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		int success = userDAO.createUser(user);
		
		if(success == 0) {
			PrintWriter out = resp.getWriter();
			out.print("<div class=\"alert alert-danger\">\n"
					+ "  <strong>Error!</strong> something went wrong.\n"
					+ "</div>");
			rd = req.getRequestDispatcher("register.jsp");
			rd.include(req, resp);
			return;
		}
		
		else {
			PrintWriter out = resp.getWriter();
			out.print("<div class=\"alert alert-success\">\n"
					+ "  <strong>Success!</strong> registered successfully.\n"
					+ "</div>");
			rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, resp);
		}
		
		
	}
	
	
	
	/*
	public static void main(String[] args) {
		User user = new User();
		user.setName("Mugdho");
		user.setPhone("+8801767229835");
		user.setEmail("mugdhodzs38@gmail.com");
		user.setPassword("12345678");
		Date dob = new Date();
		dob.setYear(2000);
		dob.setMonth(9);
		dob.setDate(20);
		System.out.println(dob.toString());
		user.setDob(dob.toString());
		user.setAddress("Dinajpur");
		user.setJoiningDate("november 2023");
		user.setRole("admin");
		
		UserDAO userDAO = new UserDAO();
		int success =  userDAO.createUser(user);
		System.out.println(success);
	}
	*/
}




