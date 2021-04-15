package sait.bms.application;

import java.io.IOException;
import sait.bms.managers.BookManagementSystem;

/**
 * The ABC Book Company wants to implement a system to manage their books more
 * efficiently. The system should allow both employees and patrons to checkout,
 * find, and list books.
 * 
 * Application driver.
 * 
 * @author Jonghyun Park
 * @version Feburary 14, 2020
 */

public class AppDriver {
	
	/**
	 * Entry point to Java application.
	 * 
	 * @param args
	 * @throws IOException Thrown when the file could not be accessed.
	 */
	public static void main(String[] args) throws IOException {
		
		BookManagementSystem books = new BookManagementSystem();
		BookManagementSystem.loadBooks();
		
	}
}
