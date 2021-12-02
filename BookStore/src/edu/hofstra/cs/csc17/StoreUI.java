package edu.hofstra.cs.csc17;
import java.util.Scanner;

abstract public class StoreUI<ProductType> {
	
  private Scanner input = new Scanner(System.in);
  private ProductType selectedProduct;
  private double totalSales = 0;

  public void run(){
	  
    System.out.println("Welcome to our store!"); 
    
    while(true){
    	
      System.out.println("Please select an option:");
      System.out.println("1. Search for product");
      System.out.println("2. Sell selected product");
      System.out.println("3. Display sales report");
      System.out.println("4. Exit");
      System.out.print("> ");
      
      int selection = input.nextInt();
      input.nextLine(); // eat the rest of the line in the input 
      
      switch(selection) {
        case 1:
          System.out.print("Product name to search for: ");

          String searchTerm = input.next();
          selectedProduct = this.findProduct(searchTerm);
          if(selectedProduct == null){
            System.out.println("Product Not Found.");
          } else {
            System.out.println("Found: " + this.displayProduct(selectedProduct));
          }

          break;
        case 2:
          if(selectedProduct == null){
            System.out.println("No product selected yet.");
          } else {
            double price = this.getPrice(selectedProduct);
            totalSales = totalSales + price;
            System.out.println("Sold " + this.displayProduct(selectedProduct) + " for $" + Double.toString(price));
          }
          break;
        case 3:
          System.out.println("Total sales today are $" + Double.toString(this.totalSales));
          break;
        case 4: 
          System.out.println("Bye!");
          System.exit(0);
          break;
        default:
          System.out.println("Nope. Try again");
          break;
      }
      System.out.println("-----------------------");
    }
  }

  abstract public ProductType findProduct(String searchTerm);

  abstract public String displayProduct(ProductType book);

  abstract public double getPrice(ProductType product);
}