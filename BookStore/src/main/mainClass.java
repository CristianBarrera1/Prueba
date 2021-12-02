package main;

import java.io.IOException;

import edu.hofstra.cs.csc17.StoreUI;
import manageErrors.MissingDataException;
import manageErrors.TooMuchDataException;


public class mainClass {

	
	
	public static void main(String[] args) throws IOException, MissingDataException, TooMuchDataException {

		
		System.out.println("Loading BOOKS");    
	    Bookstore.loadBooks();   
	    System.out.println("Loading Beverages");  
	    Bookstore.loadBeverages(); 
	    System.out.println("Loading Snacks");
	    Bookstore.loadSnacks(); 
	    System.out.println("Loading Shelves and shelf information");
	    Bookstore.loadShelves();
	    System.out.println("PRINTING BOOKS DESCRIPTION");
	    Bookstore.descriptionOfBooks();
	    System.out.println("PRINTING BOOKS SOLD");
	    Bookstore.sellBooks();
	    System.out.println("PRINTING BEVERAGES SOLD");
	    Bookstore.sellBeverages();
	    
	    System.out.println("-------------------------");
	    
	    BookstoreUI b = new BookstoreUI();
	    b.run();
	    
	}
}
