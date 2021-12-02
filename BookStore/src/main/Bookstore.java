package main;
//Cristian Barrera
//import java.util.Set;
import java.io.File;

import java.io.IOException;
//import java.util.HashSet;
import java.util.List;
import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.PublicKey;
import java.io.IOException;
import edu.hofstra.cs.bookstore.Product;
import edu.hofstra.cs.bookstore.Snack;
import edu.hofstra.cs.bookstore.Beverage;
import edu.hofstra.cs.bookstore.Shelves;
import edu.hofstra.cs.bookstore.Book;
import edu.hofstra.cs.csc17.StoreUI; //imported
import manageErrors.MissingDataException;
import manageErrors.TooMuchDataException;


public class  Bookstore { //extends BookstoreUI{

   //Lists
  static List<Book> books = new ArrayList<Book>();
  static List<Beverage> drinks = new ArrayList<Beverage>();
  static List<Snack> snacks = new ArrayList<Snack>();
  static List<Shelves> Shelf = new ArrayList<Shelves>(); //New shelf list



  public static void loadBooks()throws IOException,MissingDataException,TooMuchDataException{ 
  Path pathToBookFile = FileSystems.getDefault().getPath("src\\Book.txt");
  
  try{

  List<String> lines = Files.readAllLines(pathToBookFile);
  //Book
  for(String line:lines){
      
    String[] pieces = line.split(":");
 try{   
    if (pieces.length<4){
      throw new MissingDataException(line);
   
  }
    if(pieces.length>4){
      throw new TooMuchDataException(line);
      }
    
    String titleName = pieces[0];
    String authorName= pieces[1];
    double price= Double.parseDouble(pieces[2]);
    String genreName= pieces[3];

    Book newBook = new Book();
    newBook.title= titleName;
    newBook.authorName= authorName;
    newBook.price= price;
    newBook.genre= genreName; //shelf genre
   
    Bookstore.books.add(newBook); //Class bookstore

    System.out.println("Book information: " + titleName+" "+ authorName+" "+ price+ " " + genreName);
  }
    catch(MissingDataException String){ //Will print which book is missing data but will continue the program
      System.err.println("Missing information on Book: " + String.getMessage());
     }
     catch(TooMuchDataException String){ //Will print which book has too much data than it need
     System.err.println("Too much data on Book: " + String.getMessage());
     }
  }
}
  catch(NoSuchFileException error){ //Used before IO to explain which file DNE!
    System.err.println("ERROR!!! File: "+ pathToBookFile +" does not exist! Program Will End");
    System.exit(1); //Program will not run if we don't have books
  }
  catch(IOException exception){ //Used for any other IO error such as Parsedouble(price not being a number)
    System.err.println("WARNING!! Could not read file " + exception.getMessage()); //getmessage will tell us what exactly is the IOException
    System.exit(1); //program will not run 
  }

  }

public static void loadBeverages() throws IOException,MissingDataException,TooMuchDataException{

  Path pathToBeveragesFile= FileSystems.getDefault().getPath("src\\Beverages.txt");
  
 try{ 
  List<String> lines2 = Files.readAllLines(pathToBeveragesFile);
    
  //Beverages
  for(String line:lines2){
    String[] pieces = line.split(":");
    try{   
    if (pieces.length<2){
      throw new MissingDataException(line);
        }
    if(pieces.length>2){
      throw new TooMuchDataException(line);
        }
    String BeverageName = pieces[0];
    double Beverageprice= Double.parseDouble(pieces[1]);
    Beverage newBeverage = new Beverage();
    newBeverage.name= BeverageName;
    newBeverage.price= Beverageprice;
    
    Bookstore.drinks.add(newBeverage);
    System.out.println("Beverage information" + BeverageName + Beverageprice);
      }

    catch(MissingDataException String){ //Will print which Beverage is missing data but will continue the program
      System.out.println("Missing Data on Beverage: " + String.getMessage());
     }
     catch(TooMuchDataException String){ //Will print which Beverage has too much data than it needs
     System.err.println("Too much data on Beverage: " + String.getMessage());
     }
  }
  
}
  
  catch(NoSuchFileException error){ 
    System.err.println("ERROR!!! File: "+ pathToBeveragesFile +" Is not found! Program Will End");
    System.exit(1);
  }
  catch(IOException exception){
    System.err.println("WARNING!! Could not read file" + exception.getMessage());
    System.exit(1);
 
  }
}

public static void loadSnacks() throws IOException, MissingDataException{
  Path pathToSnacksFile= FileSystems.getDefault().getPath("src\\Snacks.txt");
  try{
  List<String> lines3 = Files.readAllLines(pathToSnacksFile);
  //Snacks
    for(String line:lines3){
      String[] pieces = line.split(":");
      try{
        if (pieces.length<2){
          throw new MissingDataException(line);
            }
        if(pieces.length>2){
          throw new TooMuchDataException(line);
            }
      String SnackName = pieces[0];
    
      double Snackprice= Double.parseDouble(pieces[1]);
      Snack newSnack = new Snack();
      newSnack.name= SnackName;
      newSnack.price= Snackprice;
      
      Bookstore.snacks.add(newSnack);
      System.out.println("Snack information:" + SnackName + Snackprice);
      }
      catch(MissingDataException String){ //Will print which Snack is missing data but will continue the program
        System.err.println("Missing Data on Snack: " + String.getMessage());
       }
       catch(TooMuchDataException String){ //Will print which Snack has too much data than it needs
       System.err.println("Too much data on Snack: " + String.getMessage());
       }
    }
  }
  catch(NoSuchFileException error){ 
    System.err.println("ERROR!!! File: "+ pathToSnacksFile +" is not found! Program will still continue !");
    
  }
  catch(IOException exception){
    System.err.println("WARNING!! Could not read file" + exception.getMessage());
    System.exit(1);
   
  }
}

public static void loadShelves() throws IOException{
  Path pathToShelvesFile = FileSystems.getDefault().getPath("src\\Shelves.txt");
  try{
  List<String> lines4 = Files.readAllLines(pathToShelvesFile);
  //Shelves
  for(String line:lines4){
    String[] pieces= line.split(":");    
  try{
    
    if(pieces.length>1){
      throw new TooMuchDataException(line);
        }
    String genreName= pieces[0];
    Shelves shelve = new Shelves();
    shelve.name = genreName;
    Bookstore.Shelf.add(shelve);
    System.out.println("Shelve information: " + genreName);
    }
    
     catch(TooMuchDataException String){ //Will print which Shelf has too much data than it needs
     System.err.println("Too much data on Shelf: " + String.getMessage());
     }

  }
    Bookstore.addBooksToShelves();
    Bookstore.countBooksOnShelf();
    System.out.println("");
    Bookstore.printShelvesInfo();
    }

    catch(NoSuchFileException error){ 
      System.err.println("ERROR!!! File: "+ pathToShelvesFile +" is not found! Program Will End");
      System.exit(1);
    }
    catch(IOException exception){
      System.err.println("WARNING!! Could not read file" + exception.getMessage());
      System.exit(1);
     
    }
  }


public static void addBooksToShelves() throws IOException{
  
  //For loop to add each book to the shelf it belongs to depending on which genre it is (Using if statement to see if equal)
 for(Shelves shelveActual: Bookstore.Shelf ){
    for(Book bookActual: Bookstore.books){
   //TESTING Loop ! System.out.println("Book Genre:  "+ bookActual.getGenre() + " Shelf: "+ shelveActual.getName());
    if(bookActual.getGenre().equals(shelveActual.getName()))
      {
      shelveActual.addBooktoList(bookActual);
      }
    }  
  }
}

public static void countBooksOnShelf() throws IOException {
  //Count how many books are on each shelf
  for(Shelves shelveActual: Bookstore.Shelf ){
    shelveActual.numberBooks = shelveActual.getBookList().size();
  }
}

public static void printShelvesInfo() throws IOException{
// Printing information of each Shelf 
	for(Shelves shelveActual: Bookstore.Shelf ) {
	  System.out.println("Shelve information \n " +
	                      "\t Name of Shelf: "+ shelveActual.getName()+" \n"+
	                      "\t Number of Books in this shelf: "+ shelveActual.getNumerBooks()+" \n"+
	                      "\t List of books: " );
	    for(Book bookActual : shelveActual.getBookList())
	    { //Will print each book that is in the shelf genre
	        System.out.println("\t\t Name of Book: "+bookActual.getName()+" Price of book: "+ bookActual.getPrice());
	    }
	}
}



public static void descriptionOfBooks() throws IOException{
	for (Book currentBook: Bookstore.books){
	  System.out.println(currentBook.description());
	}  
}

public static void sell(Product item)
  {
    System.out.println("Sold " + item.getName() + "for" + item.getPrice());
  }
  
public static void sellBooks() throws IOException{
	for (Book currentBook: Bookstore.books){
	  sell(currentBook);
	}
}

public static void sellBeverages() throws IOException{
	for (Beverage currentDrink: Bookstore.drinks){
	  sell(currentDrink);
	}
}

}


/*
     //Count how many books are on each shelf
    for(Shelves shelveActual: Bookstore.Shelf ){
      shelveActual.numberBooks = shelveActual.getBookList().size();
    }
    System.out.println("");
*/
