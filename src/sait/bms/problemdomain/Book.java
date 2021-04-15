package sait.bms.problemdomain;

import java.util.ArrayList;

/**
 * The ABC Book Company wants to implement a system to manage their books more
 * efficiently. The system should allow both employees and patrons to checkout,
 * find, and list books.
 * 
 * This object is super class.
 * 
 * @author Jonghyun Park
 * @version Feburary 14, 2020
 */
public class Book {

	long isbn;
	String callNum, total, title;
	int available;
	ArrayList<Book> books;

	public Book() {
		// Default Constructor
	}

	/**
	 * Determine the attributes that are shared between the book types and create a Book class containing them. 
	 * @param isbn
	 * @param total
	 * @param callNum
	 * @param title
	 */
	public Book(String isbn, String callNum, String available, String total, String title) {
		this.isbn = Long.parseLong(isbn);
		this.callNum = callNum;
		this.available = Integer.parseInt(available);
		this.total = total;
		this.title = title;
		books = new ArrayList<Book>();
	}

	/**
	 * The ISBN or International Standard Book Number is a unique 13-digit number
	 * assigned to books. The last digit of the ISBN determines the specific type of
	 * book.
	 * 
	 * @return the isbn
	 */
	public long getIsbn() {
		return isbn;
	}

	/**
	 * Set the one of book's the isbn
	 * 
	 * @param isbn: the isbn to set
	 */
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	/**
	 * The call number is a sequence of characters (using the Sy) that patrons use
	 * to locate reading material.
	 * 
	 * @return the callNum
	 */
	public String getCallNum() {
		return callNum;
	}

	/**
	 * Set the one of book's the call Number
	 * 
	 * @param callNum: the callNum to set
	 */
	public void setCallNum(String callNum) {
		this.callNum = callNum;
	}

	/**
	 * Get the one of book's available
	 * 
	 * @return the available
	 */
	public int getAvailable() {
		return available;
	}

	/**
	 * Set the one of book's available
	 * 
	 * @param available: the available to set
	 */
	public void setAvaialble(int available) {
		this.available = available;
	}

	/**
	 * Get the one of book's total amount
	 * 
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * Set the one of book's total amount
	 * 
	 * @param total: the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * Get the one of book's title
	 * 
	 * @return the title
	 */

	public String getTitle() {
		return title;
	}

	/**
	 * Set the one of book's title
	 * 
	 * @param title: the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the format of ChildrenBook 
	 * 
	 * @return the null
	 */
	public String getFormat() {
		return null;
	}

	/**
	 * Get the Diet of CookBook
	 * 
	 * @return the null
	 */
	public String getDiet() {
		return null;
	}

	/**
	 * Get the Genre of PaperBack
	 * 
	 * @return the null
	 */
	public String getGenre() {
		return null;
	}

	/**
	 * Get the Frequency of Pediodical
	 * 
	 * @return the null
	 */
	public String getFrequency() {
		return null;
	}

	@Override
	public String toString() {
		return String.format("%-12s%n%", "Maching books: ");
	}
}