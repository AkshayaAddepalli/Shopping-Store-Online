package shopping1;
import Users.*;

import java.util.ArrayList;

public class OnlineStore {

	public ArrayList<ProductClass> products; 
	public ArrayList<Users> users;
	public ArrayList<UserShoppingCart> userCarts;

	public OnlineStore() {
		products = new ArrayList<>();
		users = new ArrayList<>();
		userCarts = new ArrayList<>();
	}
	
	
	public void addProduct(ProductClass product) {
		products.add(product);
	}
	
	
	public void registerUser(Users user) {
	    UserShoppingCart cart = new UserShoppingCart(); 
	    userCarts.add(cart); 
	    users.add(user); 
	    System.out.println("User " + user.getUsername() + " registered with a shopping cart.");
	}
	
	
	public void addToCart(Users user, ProductClass product) {
        int index = users.indexOf(user);
        if (index != -1 && index < userCarts.size()) {
            UserShoppingCart cart = userCarts.get(index);
            cart.addToCart(product);
        } else {
            System.out.println("User not registered or doesn't have a cart.");
        }
    }
    
  
    public void checkout(Users user) {
        int index = users.indexOf(user);
        if (index != -1 && index < userCarts.size()) {
            UserShoppingCart cart = userCarts.get(index);
            cart.checkout();
        } else {
            System.out.println("User not registered or doesn't have a cart.");
        }
    }
        public void payment(Users user) {
            int index = users.indexOf(user);
            if (index != -1 && index < userCarts.size()) {
                UserShoppingCart cart = userCarts.get(index);
                cart.total();
            } else {
                System.out.println("User not registered or doesn't have a cart.");
            }
        }
}
	
	

