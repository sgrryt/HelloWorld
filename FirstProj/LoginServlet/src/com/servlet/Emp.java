package com.servlet;

public class Emp {  
//	private int id;  
//	private String fname,password,email,country;
	private String fname,lname;
	private String BookId,Author,Boook_Name,Price;
	
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getBoook_Name() {
		return Boook_Name;
	}
	public void setBoook_Name(String boook_Name) {
		Boook_Name = boook_Name;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getLastname() {  
		return lname;  
	}  
	public void setLastname(String lname) {  
		this.lname = lname;  
	}  
	
	public String getFirstname() {  
		return fname;  
	}  
	public void setFirstname(String fname) {  
		this.fname = fname;  
	}  
  

} 
