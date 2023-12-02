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
import com.entity.Book;

@WebServlet("/addbook")
public class AddBook extends HttpServlet {

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
	
	
//	public void validate (String s) {
//		HttpServletResponse resp;
//		if(s=="" | s==null | s==" ") {
//			resp.se
//		}
//	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd;

		String name = req.getParameter("name");
		int pages = convertToInt(req.getParameter("pages"));
		int stocks = convertToInt(req.getParameter("stocks"));
		String author = req.getParameter("author");
		String publication = req.getParameter("publication");
		float price = convertToFloat(req.getParameter("price"));
		String edition = req.getParameter("edition");
		int year = convertToInt(req.getParameter("year"));

		if (name == null | name.isEmpty() | name.isBlank()) {
			rd = req.getRequestDispatcher("AddBook.jsp");
			PrintWriter out = resp.getWriter();
			out.print("<div class=\"alert alert-danger\">\n" + "  <strong>Error!</strong> Name cannot be empty.\n"
					+ "</div>");
			rd.include(req, resp);
			return;
		}

		Book book = new Book();
		book.setName(name);
		book.setPages(pages);
		book.setStocks(stocks);
		book.setAuthor(author);
		book.setPublication(publication);
		book.setPrice(price);
		book.setEdition(edition);
		book.setYear(year);

		BookDAO bd = new BookDAO();

		boolean added = bd.addBook(book);

		if (!added) {
			rd = req.getRequestDispatcher("AddBook.jsp");
			PrintWriter out = resp.getWriter();
			out.print("<div class=\"alert alert-danger\">\n" + "  <strong>Error!</strong> Something went wrong.\n"
					+ "</div>");
			rd.include(req, resp);
		}

		else {
			rd = req.getRequestDispatcher("home.jsp");
			PrintWriter out = resp.getWriter();
			out.print("<div class=\"alert alert-success\">\n" + "  <strong>The book is added to the database</strong>  .\n"
					+ "</div>");
			rd.include(req, resp);
		}

	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * Book book = new Book(); book.setName("physics"); book.setPages(600);
	 * book.setStocks(50); book.setAuthor("mugdho"); book.setPublication("giant");
	 * book.setCategory("science"); book.setLocation("shelf-3");
	 * book.setEdition("3rd"); book.setYear(2021); book.setPrice(690);
	 * 
	 * BookDAO bookDao = new BookDAO();
	 * 
	 * bookDao.addBook(book); }
	 */
}
