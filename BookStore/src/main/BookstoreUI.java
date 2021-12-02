package main;

import edu.hofstra.cs.bookstore.Product;

import java.util.Iterator;
import java.util.List;

import edu.hofstra.cs.bookstore.*;
import edu.hofstra.cs.csc17.StoreUI;

public class BookstoreUI extends StoreUI<Product> {
	
	List<Book> listBook = Bookstore.books ;
	List<Beverage> listBeverages = Bookstore.drinks ;
	List<Snack> listSnacks = Bookstore.snacks ;
	
	@Override
	public Product findProduct(String searchTerm) {
		
		for (int i = 0; i < listBook.size(); i++) {
			Book book = listBook.get(i);
			if (book.getName().equalsIgnoreCase(searchTerm)) {
				return book;
			}
		}
		
		for (Snack snack : listSnacks) {
			if (snack.getName().equalsIgnoreCase(searchTerm)) {
				return snack;
			}
		}
		
		for (Beverage beverage : listBeverages) {
			if (beverage.getName().equalsIgnoreCase(searchTerm)) {
				return beverage;
			}
		}
		
		return null;
	}

	@Override
	public String displayProduct(Product product) {
		return "Name Product:" + product.getName();
	}

	@Override
	public double getPrice(Product productPrice) {
		return productPrice.getPrice();
	}
	  //Create a subclass of Store UI
	 

}