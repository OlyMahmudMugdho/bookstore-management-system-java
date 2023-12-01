package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = new User();
		user.setPhone(phone);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		boolean matched = userDAO.loginUser(user);
		
		if(matched) {
			System.out.println("matched");
			Cookie userCookie = new Cookie("user", "logged");
			userCookie.setMaxAge(5000);
			resp.addCookie(userCookie);
			resp.sendRedirect("index.jsp");
		}
		else {
			System.out.println("not matched");
		}
	}
	
}
