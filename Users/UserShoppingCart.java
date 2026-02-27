package Users;


import java.util.ArrayList;
import java.util.Scanner;
public class UserShoppingCart implements ShoppingCart {
	
	

	private ArrayList<ProductClass> cartProducts;
	
	public UserShoppingCart() {
		cartProducts = new ArrayList<>();
	}
	
	
	@Override
	public void addToCart(ProductClass product) {
		cartProducts.add(product);

	}
	
	@Override
	public void checkout() {
		double totalPrice = 0.0;
		for (ProductClass product : cartProducts) {
			totalPrice += product.getPrice();
			System.out.println("Product: "+product.getName());
			System.out.println("Price: "+product.getPrice());
			System.out.println("Description: "+product.getDescription());
		}
		
		System.out.println("The total price of items in the cart is: Rs. " + totalPrice);
			
	}
	
	
    public void addToCart(ClothingProduct clothingProduct) {
        cartProducts.add(clothingProduct);
    }


    public void addToCart(ElectronicProduct electronicProduct) {
        cartProducts.add(electronicProduct);
    }
    public void total()
    {
    	double totalAmount = 0.0;
		for (ProductClass product : cartProducts) {
			totalAmount += product.getPrice();
		}
		Scanner scanner=new Scanner(System.in);
		System.out.println("\nChoose Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Cash on Delivery");
        System.out.print("Enter choice: ");
        int paymentChoice = scanner.nextInt();
        scanner.nextLine(); 

   

        if (totalAmount == 0.0) {
            System.out.println("Your cart is empty! Add items before making a payment.");
            
        }

        if (paymentChoice == 1) {
            System.out.print("Enter Credit Card Number: ");
            String cardNumber = scanner.nextLine();
            System.out.println("Payment of Rs. " + totalAmount + " successful using Credit Card.");
        } 
        else if (paymentChoice == 2) {
            System.out.print("Enter PayPal Email: ");
            String email = scanner.nextLine();
            System.out.println("Payment of Rs. " + totalAmount + " successful using PayPal.");
        } 
        else if (paymentChoice == 3) {
            System.out.println("Payment of Rs. " + totalAmount + " will be collected upon delivery.");
        } 
        else {
            System.out.println("Invalid payment option.");
        }
   
    	
    }
	

}
