package Users;

public abstract class ProductClass {
	

	protected int productID;
	protected String name;
	protected String description;
	protected double price;

	public ProductClass(int productID, String name, String description, double price) {
		this.productID = productID;
		this.name = name;
		this.description = description;
		this.price = price;
	}


	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}

	public int getProduct() {
		return productID;
	}
	
	public void setProduct(int productID) {
		this.productID = productID;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public abstract void displaydetails();
}