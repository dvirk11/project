package Entity;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import Entity.Bookcopys;
/***
 * 
 * Entity class to define a Book in the system
 *
 */

public class Book implements Serializable {
	/**
	 * Book id
	 */
	private String idbook;
	/**
	 * Book name
	 */
	private String bookname;
	/**
	 * Book Quantity
	 */
	private int Quantity;
	/**
	 * Book location
	 */
	private String booklocation;
	/**
	 * Book edition number
	 */
	private int Editionnumber;
	/**
	 * Book Genre
	 */
	private String Genre;
	/**
	 * Book Author
	 */
	private String Author;
	/**
	 * Book Description
	 */
	private String Description;
	/**
	 * Book table of contents save as a String to pdf file
	 */
	private String tableofcontents;
	/**
	 * Book Tagged is it a wanted book or a regular book
	 */
	private String Tagged;
	/**
	 * How many copys of the book is currently on loan
	 */
	private int currentlyonloan;
	/**
	 * Book Purchase date
	 */
	private String Purchasedate;
	/**
	 * Book Execution date
	 */
	private String Executiondate;
	/**
	 * Each book has a list of copies
	 */
	public ArrayList<Bookcopys> copysofbook =new ArrayList<Bookcopys>();
	/**
	 * Each book has a list of copies
	 */
	public static  ArrayList<Book> books =new ArrayList<Book>();
	
	/***
	 * Constructor for the server side Employees
	 * 
	 * @param idbook
	 *           Book ID number
	 * @param bookname
	 *            book name
	 * @param quantity 
                  quantity of the book
	 * @param booklocation 
                  where is the location of the book
	 * @param editionnumber 
                  The edition number of the book
	 * @param genre
	 *            What genre is the book
	 * @param author
	 *            Who wrote the book
	 *@param description       
	 *             A few sentences to describe the book
	 *@param tableofcontents
	 *             Picture of the table of contents of the book 
	 *@param tagged 
	 *             What kind of book
	 *@param currentlyonloan
	 *@param purchasedate
	 *              The day the book was purchase
	 *@param executiondate
	 *              The day the book was publishing
	 * 
	 */
	
	public Book(String idbook, String bookname, int quantity, String booklocation, int editionnumber, String genre,
			String author, String description, String tableofcontents, String tagged, int currentlyonloan,
			String purchasedate, String executiondate) {
		super();
		this.idbook = idbook;
		this.bookname = bookname;
		Quantity = quantity;
		this.booklocation = booklocation;
		Editionnumber = editionnumber;
		Genre = genre;
		Author = author;
		Description = description;
		this.tableofcontents = tableofcontents;
		Tagged = tagged;
		this.currentlyonloan = currentlyonloan;
		Purchasedate = purchasedate;
		Executiondate = executiondate;
	}
	/***
	 * 
	 * @return the Book ID
	 */
	public String getIdbook() {
		return idbook;
	}
	/***
	 * 
	 * @param Book ID
	 *            to set
	 */
	public void setIdbook(String idbook) {
		this.idbook = idbook;
	}
	/***
	 * 
	 * @return the Book name
	 */
	public String getBookname() {
		return bookname;
	}
	/***
	 * 
	 * @param Book name
	 *            to set
	 */
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	/***
	 * 
	 * @return the Book Quantity
	 */
	public int getQuantity() {
		return Quantity;
	}
	/***
	 * 
	 * @param Book Quantity
	 *            to set
	 */
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	/***
	 * 
	 * @return the Book location
	 */
	public String getBooklocation() {
		return booklocation;
	}
	/***
	 * 
	 * @param Book location
	 *            to set
	 */
	public void setBooklocation(String booklocation) {
		this.booklocation = booklocation;
	}
	/***
	 * 
	 * @return the Book Edition number
	 */
	public int getEditionnumber() {
		return Editionnumber;
	}
	/***
	 * 
	 * @param Book Edition number
	 *            to set
	 */
	public void setEditionnumber(int editionnumber) {
		Editionnumber = editionnumber;
	}
	/***
	 * 
	 * @return the Book Genre
	 */
	public String getGenre() {
		return Genre;
	}
	/***
	 * 
	 * @param Book Genre
	 *            to set
	 */
	public void setGenre(String genre) {
		Genre = genre;
	}
	/***
	 * 
	 * @return the Book Author
	 */
	public String getAuthor() {
		return Author;
	}
	/***
	 * 
	 * @param Book Author
	 *            to set
	 */
	public void setAuthor(String author) {
		Author = author;
	}
	/***
	 * 
	 * @return the Book description
	 */
	public String getDescription() {
		return Description;
	}
	/***
	 * 
	 * @param Book description
	 *            to set
	 */
	public void setDescription(String description) {
		Description = description;
	}
	/***
	 * 
	 * @return the Book table of contents
	 */

	public String getTableofcontents() {
		return tableofcontents;
	}
	/***
	 * 
	 * @param Book table of contents
	 *            to set
	 */
	public void setTableofcontents(String tableofcontents) {
		this.tableofcontents = tableofcontents;
	}
	/***
	 * 
	 * @return the Book Tagged
	 */
	public String getTagged() {
		return Tagged;
	}
	/***
	 * 
	 * @param Book Tagged
	 *            to set
	 */
	public void setTagged(String tagged) {
		Tagged = tagged;
	}
	/***
	 * 
	 * @return the Book currently on loan
	 */
	public int getCurrentlyonloan() {
		return currentlyonloan;
	}
	/***
	 * 
	 * @param Book currently on loan
	 *            to set
	 */
	public void setCurrentlyonloan(int currentlyonloan) {
		this.currentlyonloan = currentlyonloan;
	}
	/***
	 * 
	 * @return the Book Purchase date
	 */
	public String getPurchasedate() {
		return Purchasedate;
	}
	/***
	 * 
	 * @param Book Purchase date
	 *            to set
	 */
	public void setPurchasedate(String purchasedate) {
		Purchasedate = purchasedate;
	}
	/***
	 * 
	 * @return the Book Execution date
	 */
	public String getExecutiondate() {
		return Executiondate;
	}
	/***
	 * 
	 * @param Book Execution date
	 *            to set
	 */
	public void setExecutiondate(String executiondate) {
		Executiondate = executiondate;
	}


}
