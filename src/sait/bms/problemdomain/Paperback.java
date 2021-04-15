package sait.bms.problemdomain;

/**
 * Paperbacks have an ISBN, call number, available, total, title, author(s),
 * year of release, and genre. The last digit of the ISBN for a paperback is
 * between 4 and 7.
 * 
 * This object is sub class.
 * 
 * @author Jonghyun Park
 * @version Feburary 14, 2020
 */
public class Paperback extends Book {
	private String author;
	private String year;
	private String genre;

	public Paperback() {
		//Default Constructor
	}

	/**
	 * Determine the attributes that are used the Book class and this class
	 * 
	 * @param super(isbn, callNum, available, total, title)
	 * @param author
	 * @param year
	 * @param genre
	 */
	public Paperback(String isbn, String callNum, String available, String total, String title, String author,
			String year, String genre) {
		super(isbn, callNum, available, total, title);
		this.author = author;
		this.year = year;
		this.genre = genre;
	}

	/**
	 * Get the one of Paperback's author
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Set the one of Paperback's author
	 * 
	 * @param author: the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Get the one of Paperback's release yaer
	 * 
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Set the one of Paperback's release yaer
	 * 
	 * @param year: the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * The genre can either be Adventure, Drama, Education, Classic, Fantasy, or
	 * Science Fiction.
	 * 
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * Set the one of Paperback's type of genre
	 * 
	 * @param genre: the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return String.format("%-20s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n",
				"Maching books: ", "ISBN: ", isbn, "Call Number: ", callNum, "Available: ", available, "Total: ", total,
				"Title: ", title, "Author(s): ", author, "Year: ", year, "Genre: ", genre);
	}
}