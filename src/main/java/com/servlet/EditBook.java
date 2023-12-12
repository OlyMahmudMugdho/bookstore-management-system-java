package com.servlet;


import com.entity.Book;

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

@WebServlet("/editbook")
public class EditBook extends HttpServlet {

	public int convertToInt(String s) {
		int res;
		try {
			res = Integer.parseInt(s);
			return res;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public float convertToFloat(String s) {
		float res;
		try {
			res = Float.parseFloat(s);
			return res;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDAO userDAO = new UserDAO();
		userDAO.isAuthenticated(req, resp);
		
		RequestDispatcher rd;
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		int pages = convertToInt(req.getParameter("pages"));
		int stocks = convertToInt(req.getParameter("stocks"));
		String author = req.getParameter("author");
		String publication = req.getParameter("publication");
		float price = convertToFloat(req.getParameter("price"));
		String edition = req.getParameter("edition");
		int year = convertToInt(req.getParameter("year"));

		if (name == null | name.isEmpty()) {
			rd = req.getRequestDispatcher("EditBook.jsp");
			PrintWriter out = resp.getWriter();
			out.print("<div class=\"alert alert-danger\">\n" + "  <strong>Error!</strong> Name cannot be empty.\n"
					+ "</div>");
			rd.include(req, resp);
			return;
		}

		Book book = new Book();
		book.setId(Integer.parseInt(id));
		book.setName(name);
		book.setPages(pages);
		book.setStocks(stocks);
		book.setAuthor(author);
		book.setPublication(publication);
		book.setPrice(price);
		book.setEdition(edition);
		book.setYear(year);

		BookDAO bd = new BookDAO();

		boolean added = bd.editBook(book);

		if (!added) {
			rd = req.getRequestDispatcher("EditBook.jsp");
			PrintWriter out = resp.getWriter();
			out.print("<div class=\"alert alert-danger\">\n" + "  <strong>Error!</strong> Something went wrong.\n"
					+ "</div>");
			rd.include(req, resp);
		}

		else {
			rd = req.getRequestDispatcher("home.jsp");
			PrintWriter out = resp.getWriter();
			out.print("<div class=\"alert alert-success\">\n" + "  <strong>The book info is updated</strong>  .\n"
					+ "</div>");
			rd.include(req, resp);
		}

	}


}
