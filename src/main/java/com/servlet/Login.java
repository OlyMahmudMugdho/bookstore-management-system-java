package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dao.UserDAO;
import com.entity.User;

@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		RequestDispatcher rd;
		
		User user = new User();
		user.setPhone(phone);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		boolean matched = userDAO.loginUser(user);
		
		if(matched) {
			System.out.println("matched");
			Cookie userCookie = new Cookie("user", "logged");
			Algorithm algorithm = Algorithm.none();
			String token = JWT.create()
					.withIssuer("auth0")
					.withClaim("email",user.getEmail())
					.sign(algorithm); 
			Cookie tokenCookie = new Cookie("token", token);
			tokenCookie.setSecure(true);
			tokenCookie.setSecure(true);
			userCookie.setMaxAge(5000);
			resp.addCookie(userCookie);
			resp.addCookie(tokenCookie);
			resp.sendRedirect("home.jsp");
		}
		else {
			PrintWriter out = resp.getWriter();
			out.print("<div class=\"alert alert-danger\">\n"
					+ "  <strong>Error!</strong> wrong credentials.\n"
					+ "</div>");
			rd = req.getRequestDispatcher("index.jsp");
			rd.include(req, resp);
		}
	}
	
}
