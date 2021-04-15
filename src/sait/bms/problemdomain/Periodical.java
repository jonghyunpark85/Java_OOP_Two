package sait.bms.problemdomain;

/**
 * Periodicals have an ISBN, call number, available, total, title, and
 * frequency. The last digit of the ISBN for a periodical is either 8 or 9. A
 * periodical cannot be checked out.
 * 
 * This object is sub class.
 * 
 * @author Jonghyun Park
 * @version Feburary 14, 2020 *
 */
public class Periodical extends Book {

	private String frequency;

	public Periodical() {
		// Default Constructor
	}

	/**
	 * Determine the attributes that are used the Book class and this class
	 * 
	 * @param super(isbn, callNum, available, total, title)
	 * @param frequency
	 */
	public Periodical(String isbn, String callNum, String available, String total, String title, String frequency) {
		super(isbn, callNum, available, total, title);
		this.frequency = frequency;
	}

	/**
	 * The frequency can either be Daily, Weekly, Monthly, Bimonthly, and Quarterly.
	 * 
	 * @return the frequency
	 */
	public String getFrequency() {
		return frequency;
	}

	/**
	 * Set the one of Peridical's type of frequency
	 * 
	 * @param frequency: the frequency to set
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return String.format("%-20s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n", "Maching books: ",
				"ISBN: ", isbn, "Call Number: ", callNum, "Available: ", available, "Total: ", total, "Title: ", title,
				"Frequency: ", frequency);
	}
}