package sait.bms.problemdomain;

/**
 * Children’s books have an ISBN, call number, available, total, title,
 * author(s), and format. The last digit of the ISBN for a children’s book is 0
 * or 1.
 * 
 * This object is sub class.
 * 
 * @author Jonghyun Park
 * @version Feburary 14, 2020
 */
public class ChildrensBook extends Book {

	private String author;
	private String format;

	public ChildrensBook() {
		// Default Constructor
	}

	/**
	 * Determine the attributes that are used the Book class and this class
	 * 
	 * @param super(isbn, callNum, available, total , title)
	 * @param author
	 * @param format
	 */
	public ChildrensBook(String isbn, String callNum, String available, String total, String title, String author,
			String format) {
		super(isbn, callNum, available, total, title);
		this.author = author;
		this.format = format;

	}

	/**
	 * Get the one of ChildrenBook's author
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Set the one of ChildrenBook's author
	 * 
	 * @param author: the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * The format can either be Picture book, Early Readers, or Chapter book.
	 * 
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * Set the one of ChildrenBook's type of format
	 * 
	 * @param format: the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return String.format("%-20s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n",
				"Maching books: ", "ISBN: ", isbn, "Call Number: ", callNum, "Available: ", available, "Total: ", total,
				"Title: ", title, "Author(s): ", author, "Format: ", format);
	}
}