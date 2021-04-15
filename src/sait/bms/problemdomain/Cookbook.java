package sait.bms.problemdomain;

/**
 * Cookbooks have an ISBN, call number, available, total, title, publisher, and
 * diet. The last digit of the ISBN for a cookbook is either 2 or 3.
 * 
 * This object is sub class.
 * 
 * @author Jonghyun Park
 * @version Feburary 14, 2020
 */
public class Cookbook extends Book {

	private String pub;
	private String diet;

	public Cookbook() {

	}

	/**
	 * Determine the attributes that are used the Book class and this class
	 * 
	 * @param super(isbn, callNum, available, total , title)
	 * @param pub
	 * @param diet
	 */
	public Cookbook(String isbn, String callNum, String available, String total, String title, String pub,
			String diet) {
		super(isbn, callNum, available, total, title);
		this.pub = pub;
		this.diet = diet;

	}

	/**
	 * Get the one of CookBook's publisher
	 * 
	 * @return the pub
	 */
	public String getPub() {
		return pub;
	}

	/**
	 * Set the one of CookBook's publisher
	 * 
	 * @param pub: the pub to set
	 */
	public void setPub(String pub) {
		this.pub = pub;
	}

	/**
	 * The diet is either Diabetic, Vegetarian, Gluten-free, International, or None.
	 * 
	 * @return the diet
	 */
	public String getDiet() {
		return diet;
	}

	/**
	 * Set the one of CookBook's type of diet
	 * 
	 * @param diet: the diet to set
	 */
	public void setDiet(String diet) {
		this.diet = diet;
	}

	@Override
	public String toString() {
		return String.format("%-20s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n%-20s%s%n",
				"Maching books: ", "ISBN: ", isbn, "Call Number: ", callNum, "Available: ", available, "Total: ", total,
				"Title: ", title, "Publisher: ", pub, "Diet: ", diet);
	}
}