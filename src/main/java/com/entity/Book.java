package com.entity;

public class Book {
	
	private int id;
	private String name;
	private int pages;
	private int stocks;
	private String author;
	private String publication;
	private String category;
	private String location;
	private String edition;
	private int year;
	private float price;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public Book() {
		
	}

	public Book(int id, String name, int pages, int stocks, String author, String publication, String category,
				String location, String edition, int year, float price) {
		super();
		this.id = id;
		this.name = name;
		this.pages = pages;
		this.stocks = stocks;
		this.author = author;
		this.publication = publication;
		this.category = category;
		this.location = location;
		this.edition = edition;
		this.year = year;
		this.price = price;
	}

	public Book(String name, int pages, int stocks, String author, String publication, String category,
			String location, String edition, int year, float price) {
		super();
		this.name = name;
		this.pages = pages;
		this.stocks = stocks;
		this.author = author;
		this.publication = publication;
		this.category = category;
		this.location = location;
		this.edition = edition;
		this.year = year;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", pages=" + pages + ", stocks=" + stocks + ", author=" + author
				+ ", publication=" + publication + ", category=" + category + ", location=" + location + ", edition="
				+ edition + ", year=" + year + ", price=" + price + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getPages()=" + getPages() + ", getStocks()=" + getStocks() + ", getAuthor()=" + getAuthor()
				+ ", getPublication()=" + getPublication() + ", getCategory()=" + getCategory() + ", getLocation()="
				+ getLocation() + ", getEdition()=" + getEdition() + ", getYear()=" + getYear() + ", getPrice()="
				+ getPrice() + "]";
	}
	
}
