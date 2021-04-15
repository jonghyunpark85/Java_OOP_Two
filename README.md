# Java_OOP_Two

## Book Management System

The ABC Book Company wants to implement a system to manage their books more efficiently. The system should allow both employees and patrons to checkout, find, and list books. A data file containing a sample list of books is provided. The data file contains a combination of four different types of books: children’s books, cookbooks, paperbacks, and periodicals. Each book is uniquely identified using an ISBN and the information for each type of book is described in the formatting section.
The ABC Book Company wants an interactive program that does the following:
1.	Checkout a book.
•	Allows a patron to checkout a book using its ISBN. If the book is unavailable, the user will be informed and the program will return back to the main menu. Otherwise, if the book is available, the available count will be decremented and the book information will be displayed.
2.	Find books by title.
•	Allows a patron to enter a search term and the program will display a list of books that have a title matching the search term.
3.	Display books of a specific type.
•	Allows a patron to view a list of books with a specific type. The user will also enter a format, diet, genre, or frequency (depending on the type of book) and the book list will be narrowed down further.
4.	Produce a list of random books.
•	Allows a patron to print a list of random books. The list of books can contain any type of book.
 
Formatting
Each type of book listed below is represented differently in the supplied “books.txt” file. Each line in the file represents a different book and each piece of information for a book is separated by a semi-colon.
Children’s Books
Children’s books have an ISBN, call number, available, total, title, author(s), and format. The last digit of the ISBN for a children’s book is 0 or 1. The format can either be Picture book, Early Readers, or Chapter book. 
Each children’s book is represented in the “books.txt” file as follows:
ISBN;Call number;Available;Total;Title;Authors;Format
Example: 9782092530030;813.6;1;14;I Need a New Butt!;Dawn McMillan, Ross Kinnaird;E
Cookbooks
Cookbooks have an ISBN, call number, available, total, title, publisher, and diet. The last digit of the ISBN for a cookbook is either 2 or 3. The diet is either Diabetic, Vegetarian, Gluten-free, International, or None.
Each cookbook is represented in the “books.txt” file as follows:
ISBN;Call number;Available;Total;Title;Publisher;Diet
Example: 9787518397792;641.6 DOG;4;5;From Crook to Cook;Snoop Dogg;N
Paperbacks
Paperbacks have an ISBN, call number, available, total, title, author(s), year of release, and genre. The last digit of the ISBN for a paperback is between 4 and 7. The genre can either be Adventure, Drama, Education, Classic, Fantasy, or Science Fiction.
Each novel is represented in the “books.txt” file as follows:
ISBN;Call number;Available;Total;Title;Authors;Year;Genre
Example: 9782232375484;822.33 SHA;6;6;Hamlet;William Shakespeare;1602;C
Periodicals
Periodicals have an ISBN, call number, available, total, title, and frequency. The last digit of the ISBN for a periodical is either 8 or 9. The frequency can either be Daily, Weekly, Monthly, Bimonthly, and Quarterly. A periodical cannot be checked out.
Each periodical is represented in the “books.txt” file as follows:
ISBN;Call number;Available;Total;Title;Frequency
Example: 9782346146918;050;0;5;Dogster;B 
Details
The ISBN or International Standard Book Number is a unique 13-digit number assigned to books. The last digit of the ISBN determines the specific type of book. Note that the maximum value for int is only 10 digits, therefore a bigger data type is required.
The call number is a sequence of characters (using the Sy) that patrons use to locate reading material. You are not required to validate the call number.
Given the formatting for the types of books:
•	Determine the attributes that are shared between the book types and create a Book class containing them. The Book class cannot be instantiated and must be a super-class.
•	Create the following classes where each one of them is to inherit the Book class and be located in the sait.bms.problemdomain package.
o	Cookbook
o	ChildrensBook
o	Paperback
o	Periodical
•	Each one of these classes is to have a user-defined constructor that assigns the appropriate attributes.
•	Override the toString() method in each one of these classes, so that the data is in a human readable form. The attributes should be displayed using vertical headers.
Along with the functionality mentioned above, you will need the following methods in your program:
a)	Implement a method that parses the supplied “books.txt” file into a single array list. The array list will be able to contain all Book types (cookbooks, children’s books, and paperbacks). Use the last digit of the ISBN to determine what a valid type of book needs to be created (see Formatting for more information). 
b)	Implement a method that allows a patron to checkout a book. The user patron will be prompted to enter the ISBN of a book. If the entered ISBN does not match, the program will inform the patron with an error message. If the ISBN matches, the program checks the book’s availability. If there is a book available, the available count will be decremented and the books information will be displayed. Otherwise, the user patron will be informed the book is not available. 
c)	Implement a method that prompts the user patron to enter a title, performs a case-insensitive search of books that containing the inputted title, and displays them.
d)	Implement a method that prompts the user for a type of book and displays all books of that type. Down-casting is required to determine the type of book is what the user specified.
e)	Implement a method that prompts a user to enter a number and the program displays that number of random books. The books can be any type. The Collections.shuffle method maybe used.
f)	Implement and call a method, when the program exits, that takes the books stored in the array list and persists them back to the “books.txt” file in the proper format. 
