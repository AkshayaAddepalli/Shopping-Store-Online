package shopping1;
import Users.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OnlineStore onlineStore = new OnlineStore();
        List<Users> users = new ArrayList<>();
         try {
            FileReader fileReader = new FileReader("C:/Users/addep/OneDrive/Desktop/data.txt");
            Scanner fileScanner = new Scanner(fileReader);
            String productType = "";

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) continue;
                if (line.startsWith("Product ID")) {
                	if(line.contains("Warranty Period"))
                		productType="Electronic";
                	else if(line.contains("Size"))
                		productType="Clothing";
                	else if(line.contains("Type"))
                		productType="Snacks";
                	else if(line.contains("Genre"))
                		productType="Books";
                    continue;
                }
                String[] parts = line.split(", ");
                if (productType.equals("Electronic")) {
                    if (parts.length < 7) continue;
                    int productId = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String description = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    String brand = parts[4].trim();
                    String model = parts[5].trim();
                    int warrantyPeriod = Integer.parseInt(parts[6].trim());
                    ElectronicProduct electronicProduct = new ElectronicProduct(productId, name, description, price, brand, model, warrantyPeriod);
                    onlineStore.addProduct(electronicProduct);
                } else if (productType.equals("Clothing")) {
                    if (parts.length < 7) continue;
                    int productId = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String description = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    String size = parts[4].trim();
                    String material = parts[5].trim();
                    String availableColors = parts[6].trim();
                    ClothingProduct clothingProduct = new ClothingProduct(productId, name, description, price, size, material, availableColors);
                    onlineStore.addProduct(clothingProduct);
                }
                else if (productType.equals("Snacks")) {
                    if (parts.length < 5) continue;
                    int productId = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String description = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    String type=parts[4].trim();
                    Snacks snack = new Snacks(productId, name, description, price,type);
                    onlineStore.addProduct(snack);
                }
                else if(productType.equals("Books"))
                {
                	if (parts.length < 6) continue;
                    int productId = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String description = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    String genre=parts[4].trim();
                    String author=parts[5].trim();
                    Books book = new Books(productId, name, description, price,genre,author);
                    onlineStore.addProduct(book);
                }
            }
            fileReader.close();
            fileScanner.close();
        } catch (IOException e) {
            System.out.println("There has been an error during file handling");
        }

        int choice;
        do {
            System.out.println("\n===== ONLINE STORE MENU =====");
            System.out.println("1. Register User");
            System.out.println("2. Display Products");
            System.out.println("3. Add to Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Pay");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    Users newUser = new Users(username);
                    users.add(newUser);
                    onlineStore.registerUser(newUser);
                    System.out.println(username + " registered successfully.");
                    break; 
                case 2:
                    System.out.println("\nAvailable Products:");
                    for (ProductClass product : onlineStore.products) {
                        System.out.print(product.getProduct()+". ");
                        if (product instanceof ElectronicProduct) {
                            ElectronicProduct electronic = (ElectronicProduct) product;
                            electronic.displaydetails();
                        }
                        if (product instanceof ClothingProduct )
                        {
                        	ClothingProduct clothing=(ClothingProduct) product;
                        	clothing.displaydetails();
                        }
                        if (product instanceof Snacks )
                        {
                        	Snacks snack=(Snacks) product;
                        	snack.displaydetails();
                        }
                        if (product instanceof Books )
                        {
                        	Books book=(Books) product;
                        	book.displaydetails();
                        	}
                        }
                       break;
                case 3:
                    System.out.print("Enter your username: ");
                    String cartUser = scanner.nextLine();
                    Users currentUser = findUser(users, cartUser);
                    if (currentUser == null) {
                        System.out.println("User not found!");
                        break;
                    }
                    System.out.print("Enter Product number to add to cart: ");
                    int productId = scanner.nextInt();
                    ProductClass selectedProduct = findProduct(onlineStore, productId);
                    if (selectedProduct != null) {
                        onlineStore.addToCart(currentUser, selectedProduct);
                        System.out.println(selectedProduct.getName() + " added to cart.");
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter your username for checkout: ");
                    String checkoutUser = scanner.nextLine();
                    Users checkoutUserObj = findUser(users, checkoutUser);
                    if (checkoutUserObj == null) {
                        System.out.println("User not found!");
                        break;
                    }
                    onlineStore.checkout(checkoutUserObj);
                    break;
                
                case 5:
                    System.out.print("Enter your username: ");
                    String payingUser = scanner.nextLine();
                    Users user = findUser(users, payingUser);
                    if (user == null) {
                        System.out.println("User not found!");
                        break;
                    }
                    onlineStore.payment(user); 

                    break;

                 
                case 6:
                    System.out.println("Exited. Thank you! Shop Again!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            
        }while (choice != 6);
        
    }

    private static Users findUser(List<Users> users, String username) {
        for (Users user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    private static ProductClass findProduct(OnlineStore store, int productId) {
        for (ProductClass product : store.products) {
            if (product.getProduct() == productId) {
                return product;
            }
        }
        return null;
    }
}
