package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.conn.DBConnection;
import com.entity.Book;

public class BookDAO {
	private final String ADD_BOOK_QUERY = "insert into book(name,pages,stocks,author,publication,category,location,edition,year,price) \n"
			+ "values(?,?,?,?,?,?,?,?,?,?);";
	
	public boolean addBook(Book book) {
		try {
			Connection conn = DBConnection.connect();
			PreparedStatement ps = conn.prepareStatement(ADD_BOOK_QUERY);
			ps.setString(1,(book.getName()==null) ? " " : book.getName() );
			ps.setInt(2, book.getPages() );
			ps.setInt(3, book.getStocks());
			ps.setString(4, (book.getAuthor() == null) ? " " : book.getAuthor());
			ps.setString(5, (book.getPublication() == null) ? " " : book.getPublication());
			ps.setString(6, (book.getCategory() == null) ? " " : book.getCategory());
			ps.setString(7, (book.getLocation() == null) ? " " : book.getLocation());
			ps.setString(8, (book.getEdition() == null) ? " " : book.getEdition());
			ps.setInt(9, book.getYear());
			ps.setFloat(10, book.getPrice());
			
			int isExecuted =  ps.executeUpdate();
			System.out.println(isExecuted);
			
			return (isExecuted == 1) ? true :  false;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
