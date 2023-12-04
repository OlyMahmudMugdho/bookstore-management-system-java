package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.conn.DBConnection;
import com.entity.Book;

public class BookDAO {
	private final String ADD_BOOK_QUERY = "insert into book(name,pages,stocks,author,publication,category,location,edition,year,price) \n"
			+ "values(?,?,?,?,?,?,?,?,?,?);";
	
	private final String GET_ALL_BOOKS_QUERY = "select * from book;";
	private final String GET_SINGLE_BOOK = "select * from book where id = ?;";
	private final String EDIT_BOOK_QUERY = "update\n"
			+ "	book\n"
			+ "set\n"
			+ "	\"name\" = ?,\n"
			+ "	pages = ?,\n"
			+ "	stocks = ?,\n"
			+ "	author = ?,\n"
			+ "	\"publication\" = ?,\n"
			+ "	category = ?,\n"
			+ "	\"location\" = ?,\n"
			+ "	edition = ?,\n"
			+ "	\"year\" = ?,\n"
			+ "	price = ?\n"
			+ "where \n"
			+ "	id = ?;";
	
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
	
	
	public List<Book> getBooks() {
		List<Book> booklist = new ArrayList<Book>();
		
		try {
			Connection conn = DBConnection.connect();
			PreparedStatement ps = conn.prepareStatement(GET_ALL_BOOKS_QUERY);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getString(1));
				book.setName(rs.getString(2));
				book.setPages(rs.getInt(3));
				book.setStocks(rs.getInt(4));
				book.setAuthor(rs.getString(5));
				book.setPublication(rs.getString(6));
				book.setCategory(rs.getString(7));
				book.setLocation(rs.getString(8));
				book.setEdition(rs.getString(9));
				book.setYear(rs.getInt(10));
				book.setPrice(rs.getFloat(11));
				
				booklist.add(book);
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return booklist;
	}
	
	
	public Book getBookFromID(int id) {
		Book book = new Book();
		
		try {
			Connection conn = DBConnection.connect();
			PreparedStatement ps = conn.prepareStatement(GET_SINGLE_BOOK);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				book.setId(rs.getString(1));
				book.setName(rs.getString(2));
				book.setPages(rs.getInt(3));
				book.setStocks(rs.getInt(4));
				book.setAuthor(rs.getString(5));
				book.setPublication(rs.getString(6));
				book.setCategory(rs.getString(7));
				book.setLocation(rs.getString(8));
				book.setEdition(rs.getString(9));
				book.setYear(rs.getInt(10));
				book.setPrice(rs.getFloat(11));				
				System.out.println(rs.getString(1));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return  book;
	}
	
	
	
	public boolean editBook(Book book) {
		try {
			Connection conn = DBConnection.connect();
			PreparedStatement ps = conn.prepareStatement(EDIT_BOOK_QUERY);
			
			 
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
			ps.setInt(11, Integer.parseInt(book.getId()));
			
			System.out.println(ps.toString());
			int isExecuted =  ps.executeUpdate();
			System.out.println(isExecuted);
			
			return (isExecuted == 1) ? true :  false;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	public void printBooks() {
		List<Book> booklist = new ArrayList<Book>();
		
		try {
			Connection conn = DBConnection.connect();
			PreparedStatement ps = conn.prepareStatement(GET_ALL_BOOKS_QUERY);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Book book = new Book();
				//book.setId(rs.getString(1));
				System.out.println(rs.getString(1));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ;
	}
	
	
}
