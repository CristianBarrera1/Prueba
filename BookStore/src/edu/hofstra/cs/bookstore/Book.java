package edu.hofstra.cs.bookstore;

public class Book implements Product {
    public  String title;
    public String authorName;
    public double price;
    public String genre; //Each book will have a genre
    
  
    
    public String description(){
      return this.title + " by " + this.authorName;
    }
  
    public String getName(){
      return this.title;
    }
  
    public double getPrice(){
      return this.price;
    }
    public String getGenre(){ 
      return this.genre;
    }
}
