package sait.bms.managers;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sait.bms.problemdomain.Book;
import sait.bms.problemdomain.ChildrensBook;
import sait.bms.problemdomain.Cookbook;
import sait.bms.problemdomain.Paperback;
import sait.bms.problemdomain.Periodical;

/**
 * The ABC Book Company wants to implement a system to manage their books more
 * efficiently. The system should allow both employees and patrons to checkout,
 * find, and list books.
 * 
 * Book Management System.
 * 
 * @author Jonghyun Park
 * @version Feburary 14, 2020
 */
public class BookManagementSystem {

	static Scanner in = new Scanner(System.in);

	// The array list will be able to contain all Book types (cookbooks, children’s
	// books, and paperbacks).
	static ArrayList<Book> books = new ArrayList<Book>();
	static String filepath;

	/**
	 * Display Menu for Book Management System.
	 * 
	 * @throws IOException Thrown when the file could not be accessed.
	 */
	public static void displayMenu() throws IOException {

		int choiceNum = 0;

		while (choiceNum != 5) {
			System.out.println("Welcome in ABC Book Company: How May We Assist You?");
			System.out.printf("%-6s%s%n", "1", "Checkout Book");
			System.out.printf("%-6s%s%n", "2", "Find Books by Title");
			System.out.printf("%-6s%s%n", "3", "Display Books by Type");
			System.out.printf("%-6s%s%n", "4", "Produce Ramdom Book List");
			System.out.printf("%-6s%s%n%n", "5", "Save & Exit");

			System.out.print("Enter option: ");

			do {
				while (!in.hasNextInt()) {
					System.out.println("Please enter the number!");
					in.next();

					System.out.println("Welcome in ABC Book Company: How May We Assist You?");
					System.out.printf("%-6s%s%n", "1", "Checkout Book");
					System.out.printf("%-6s%s%n", "2", "Find Books by Title");
					System.out.printf("%-6s%s%n", "3", "Display Books by Type");
					System.out.printf("%-6s%s%n", "4", "Produce Ramdom Book List");
					System.out.printf("%-6s%s%n%n", "5", "Save & Exit");
					System.out.print("Enter option: ");
				}
				choiceNum = in.nextInt();
			} while (choiceNum <= 0);

			switch (choiceNum) {
			case 1:
				checkOut();
				break;
			case 2:
				findBooks();
				break;
			case 3:
				typeBooks();
				break;
			case 4:
				randomBooks();
				break;
			case 5:
				saveBooks();
				break;
			default:
				System.out.println("Invalid option!\n");
				break;
			}
		}
	}

	/**
	 * Allows a patron to checkout a book using its ISBN. If the book is
	 * unavailable, the user will be informed and the program will return back to
	 * the main menu. Otherwise, if the book is available, the available count will
	 * be decremented and the book information will be displayed.
	 * 
	 * @throws IOException Thrown when the file could not be accessed.
	 */
	public static void checkOut() throws IOException {

		System.out.print("Enter ISBN of book: ");
		long searchIsbn = 0;

		do {
			while (!in.hasNextLong()) {
				System.out.println("Please enter the number!");
				in.next();
				displayMenu();
			}
			searchIsbn = in.nextLong();
		} while (searchIsbn <= 0);

		long lastDigit = searchIsbn % 10;
		int isbnSize = Long.toString(searchIsbn).length();

		for (int i = 0; i < books.size(); i++) {

			if (lastDigit == 8 || lastDigit == 9) {
				System.out.println("All of perdical books cannot check out.");
				System.out.println("Try again.");
				break;
			}
			if (isbnSize != 13) {
				System.out.println("You have to type 13 digit numbers!");
				System.out.println("Try again!!");
				break;
			}

			long isbnResult = books.get(i).getIsbn();
			int bookAvailable = books.get(i).getAvailable();

			if (searchIsbn == isbnResult && bookAvailable == 0) {
				System.out.println("This book is not available.");
				System.out.println("Try another book.");
				break;
			}
			if (searchIsbn == isbnResult) {
				System.out.println("\nThe book \"" + books.get(i).getTitle() + "\" has been checked out.");
				System.out.println("It can be located using a call number: " + books.get(i).getCallNum());
				System.out.println();
				break;
			}
		}
	}

	/**
	 * Allows a patron to enter a search term and the program will display a list of
	 * books that have a title matching the search term.Implement a method that
	 * prompts the user patron to enter a title, performs a case-insensitive search
	 * of books that containing the inputed title, and displays them.
	 */
	public static void findBooks() {

		System.out.print("Enter title to search for: ");
		String searchTitle = in.next();

		for (int i = 0; i < books.size(); i++) {

			String title = books.get(i).getTitle();

			if (title.toLowerCase().contains(searchTitle.toLowerCase())) {
				System.out.println(books.get(i));
			}
		}
	}

	/**
	 * Allows a patron to view a list of books with a specific type. The user will
	 * also enter a format, diet, genre, or frequency (depending on the type of
	 * book) and the book list will be narrowed down further.
	 * 
	 * @throws IOException Thrown when the file could not be accessed.
	 */
	public static void typeBooks() throws IOException {

		int searchType = 0;

		System.out.printf("%-6s%s%n", "#", "Type");
		System.out.printf("%-6s%s%n", "1", "Chileren's Books");
		System.out.printf("%-6s%s%n", "2", "CookBooks");
		System.out.printf("%-6s%s%n", "3", "Paperbacks");
		System.out.printf("%-6s%s%n%n", "4", "Peridicals");
		System.out.print("Enter type of book: ");

		do {
			while (!in.hasNextInt()) {
				System.out.println("Please enter the number!");
				in.next();
				displayMenu();
			}
			searchType = in.nextInt();
		} while (searchType <= 0);

		if (searchType == 1) {
			System.out.print("Enter the format (P for picture book, " + "E for early readers, C for Chapter book): ");
			String searchFormat = in.next();
			String formatWord = "PpEeCc";

			for (int i = 0; i < books.size(); i++) {

				char a = searchFormat.charAt(0);

				if (!Character.isLetter(a) || searchFormat.length() != 1) {
					System.out.println("Please enter the one letter!");
					break;
				}
				if (!(formatWord.contains(searchFormat))) {
					System.out.println("Please check for type letter");
					break;
				}
				long typeIsbn = books.get(i).getIsbn();
				long lastDigit = typeIsbn % 10;
				String formatList = books.get(i).getFormat();

				if ((lastDigit == 0 || lastDigit == 1)) {
					if (searchFormat.equalsIgnoreCase(formatList)) {
						System.out.println(books.get(i));
					}
				}
			}
		} else if (searchType == 2) {
			System.out.print("Enter the diet (D for Diabetic, V for Vegetarian, G for Gluten-free, "
					+ "I for International, N for None): ");
			String searchDiet = in.next();
			String dietWord = "DdVvGgIiNn";

			for (int i = 0; i < books.size(); i++) {

				char a = searchDiet.charAt(0);

				if (!Character.isLetter(a) || searchDiet.length() != 1) {
					System.out.println("Please enter the one letter!");
					break;
				}
				if (!(dietWord.contains(searchDiet))) {
					System.out.println("Please check for type letter");
					break;
				}

				long typeIsbn = books.get(i).getIsbn();
				long lastDigit = typeIsbn % 10;
				String dietList = books.get(i).getDiet();

				if ((lastDigit == 2 || lastDigit == 3)) {
					if (searchDiet.equalsIgnoreCase(dietList)) {
						System.out.println(books.get(i));
					}
				}
			}
		} else if (searchType == 3) {
			System.out.print("Enter the genre (A for Adventure, D for Drama, E for Education,"
					+ "C for classic, F for Fantasy, S for Science Fiction): ");
			String searchGenre = in.next();
			String genreWord = "AaDdEeCcFfSs";

			for (int i = 0; i < books.size(); i++) {

				char a = searchGenre.charAt(0);

				if (!Character.isLetter(a) || searchGenre.length() != 1) {
					System.out.println("Please enter the one letter!");
					break;
				}
				if (!(genreWord.contains(searchGenre))) {
					System.out.println("Please check for type letter");
					break;
				}
				long typeIsbn = books.get(i).getIsbn();
				long lastDigit = typeIsbn % 10;
				String genreList = books.get(i).getGenre();

				if ((lastDigit == 2 || lastDigit == 3)) {
					if (searchGenre.equalsIgnoreCase(genreList)) {
						System.out.println(books.get(i));
					}
				}
			}
		} else if (searchType == 4) {
			System.out.print("Enter the frequency (D for Daily, W for Weekily, M for Monthly, "
					+ "B for Bimonthly, Q for Quarterly): ");
			String searchFrequency = in.next();
			String frequencyWord = "DdWwMmBbQq";

			for (int i = 0; i < books.size(); i++) {

				char a = searchFrequency.charAt(0);

				if (!Character.isLetter(a) || searchFrequency.length() != 1) {
					System.out.println("Please enter the one letter!");
					break;
				}
				if (!(frequencyWord.contains(searchFrequency))) {
					System.out.println("Please check for type letter");
					break;
				}
				long typeIsbn = books.get(i).getIsbn();
				long lastDigit = typeIsbn % 10;
				String FrequencyList = books.get(i).getFrequency();

				if ((lastDigit == 8 || lastDigit == 9)) {
					if (searchFrequency.equalsIgnoreCase(FrequencyList)) {
						System.out.println(books.get(i));
					}
				}
			}
		} else {
			System.out.println("Invalid option!\n");
		}
	}

	/**
	 * Allows a patron to print a list of random books. The list of books can
	 * contain any type of book.
	 * 
	 * @throws IOException Thrown when the file could not be accessed.
	 */
	public static void randomBooks() throws IOException {

		int random = 0;
		boolean available = true;
		System.out.print("Enter number of books: ");
		do {
			while (!in.hasNextLong()) {
				System.out.println("Please enter the number!");
				in.next();
				displayMenu();
			}
			random = in.nextInt();
		} while (random <= 0);
		while (available) {
			if (random < 0) {
				System.out.println("Wrong number! Try Again!");
				available = false;
			} else {
				Collections.shuffle(books);
				for (int i = 0; i < random; i++) {
					System.out.println(books.get(i));
					available = false;
				}
			}
		}
	}

	/**
	 * Implement and call a method, when the program exits, that takes the books
	 * stored in the array list and persists them back to the “books.txt” file in
	 * the proper format.
	 * 
	 * @throws IOException Thrown when the file could not be accessed.
	 */
	public static void saveBooks() throws IOException {

		System.out.println("Data will be saved");
		File file = new File(filepath);
		PrintWriter pw = new PrintWriter(file);

		for (int i = 0; i < books.size(); i++) {
			String isbn = String.valueOf(books.get(i).getIsbn());
			String callNum = books.get(i).getCallNum();
			String available = String.valueOf(books.get(i).getAvailable());
			String total = books.get(i).getTotal();
			String title = books.get(i).getTitle();

			if (isbn.endsWith("0") || isbn.endsWith("1")) {
				String author = ((ChildrensBook) books.get(i)).getAuthor();
				String format = ((ChildrensBook) books.get(i)).getFormat();
				pw.println(isbn + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + author + ";"
						+ format);
			} else if (isbn.endsWith("2") || isbn.endsWith("3")) {
				String pub = ((Cookbook) books.get(i)).getPub();
				String diet = ((Cookbook) books.get(i)).getDiet();
				pw.println(isbn + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + pub + ";" + diet);
			} else if (isbn.endsWith("4") || isbn.endsWith("5") || isbn.endsWith("6") || isbn.endsWith("7")) {
				String author = ((Paperback) books.get(i)).getAuthor();
				String year = ((Paperback) books.get(i)).getYear();
				String genre = ((Paperback) books.get(i)).getGenre();
				pw.println(isbn + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + author + ";"
						+ year + ";" + genre);
			} else if (isbn.endsWith("8") || isbn.endsWith("9")) {
				String frequency = ((Periodical) books.get(i)).getFrequency();
				pw.println(isbn + ";" + callNum + ";" + available + ";" + total + ";" + title + ";" + frequency);
			}
		}
		pw.close();
		System.out.println("Your data has benn saved. Good Bye!!");
	}

	/**
	 * A data file containing a sample list of books is provided. The data file
	 * contains a combination of four different types of books: children’s books,
	 * cookbooks, paperbacks, and periodicals.Each book is uniquely identified using
	 * an ISBN and the information for each type of book is described in the
	 * formatting section.
	 * 
	 * @throws IOException Thrown when the file could not be accessed.
	 */
	public static void loadBooks() throws IOException {

		System.out.print("Enter the book database file path: ");
		filepath = in.nextLine();
		// File file = new File("C:/workspaceprg251/Assignment 2/res/books.txt");
		File file = new File(filepath);
		Scanner inFile = new Scanner(file);

		while (inFile.hasNextLine()) {
			String line = inFile.nextLine();
			String[] seperateLine = line.split(";");
			String isbn = seperateLine[0];
			String callNum = seperateLine[1];
			String available = seperateLine[2];
			String total = seperateLine[3];
			String title = seperateLine[4];

			if (isbn.endsWith("0") || isbn.endsWith("1")) {
				String author = seperateLine[5];
				String format = seperateLine[6];
				Book chb = new ChildrensBook(isbn, callNum, available, total, title, author, format);
				books.add(chb);

			} else if (isbn.endsWith("2") || isbn.endsWith("3")) {
				String pub = seperateLine[5];
				String diet = seperateLine[6];
				Book cb = new Cookbook(isbn, callNum, available, total, title, pub, diet);
				books.add(cb);
			} else if (isbn.endsWith("4") || isbn.endsWith("5") || isbn.endsWith("6") || isbn.endsWith("7")) {
				String author = seperateLine[5];
				String year = seperateLine[6];
				String genre = seperateLine[7];
				Book pb = new Paperback(isbn, callNum, available, total, title, author, year, genre);
				books.add(pb);
			} else if (isbn.endsWith("8") || isbn.endsWith("9")) {
				String frequency = seperateLine[5];
				Book p = new Periodical(isbn, callNum, available, total, title, frequency);
				books.add(p);
			}
		}
		inFile.close();
		displayMenu();
	}
}
