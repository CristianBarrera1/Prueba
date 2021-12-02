package edu.hofstra.cs.bookstore;

public class Beverage implements Product{
   public  String name;
   public  double price;
   public  String genre;

    public String getName(){
    return this.name;
  }

    public double getPrice(){
    return this.price;
  }
    
}
