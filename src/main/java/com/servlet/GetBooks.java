package com.servlet;

import java.util.List;

import com.dao.BookDAO;
import com.entity.Book;

public class GetBooks {

	public static void main(String[] args) {
		
		BookDAO bd = new BookDAO();
		List<Book> booklist = bd.getBooks();
		
		for(Book book : booklist) {
			System.out.println(book.toString());;
		}
	}

}
