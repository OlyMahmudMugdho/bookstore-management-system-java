package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDAO;
import com.dao.UserDAO;

@WebServlet("/deletebook")
public class DeleteBook extends HttpServlet {
	RequestDispatcher rd;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		BookDAO bd = new BookDAO();
		UserDAO userDAO = new UserDAO();
		userDAO.isAuthenticated(req, resp);
		boolean deleted = bd.deleteBook(id);
		
		if(deleted) {
			rd = req.getRequestDispatcher("home.jsp");
			PrintWriter out = resp.getWriter();
			out.print("<div class=\"alert alert-success\">\n" + "  <strong>The book is deleted</strong>  .\n"
					+ "</div>");
			rd.include(req, resp);
		}
		else {
			rd = req.getRequestDispatcher("home.jsp");
			PrintWriter out = resp.getWriter();
			out.print("<div class=\"alert alert-danger\">\n" + "  <strong>Something went wrong</strong>  .\n"
					+ "</div>");
			rd.include(req, resp);
		}
		
	}
	
}
