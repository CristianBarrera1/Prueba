package edu.hofstra.cs.bookstore;
import java.util.List;
import java.util.ArrayList;

public class Shelves {
   public String name;
   public int numberBooks;
   public List<Book> bookList;

    public Shelves(){ 
      this.bookList  = new ArrayList<Book>();
    }

    public String getName(){ //name of shelf(genre)
      return this.name;
    }

    public int getNumerBooks(){ //int to declare # of books in shelf
      return this.numberBooks;
    }

    public List<Book> getBookList(){  //to use the BookList created 
      return this.bookList;
    }
    public void addBooktoList(Book book){ //Will be used to add books into shelves 
      this.bookList.add(book);
    }
    
}
