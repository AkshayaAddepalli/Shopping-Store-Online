package Users;


public class ClothingProduct extends ProductClass {
	
	protected String size;
	protected String material;
	protected String availableColors;
	protected double price;
	
	public ClothingProduct(int productID, String name, String description, double price, String size, String material, String availableColors) {
		super(productID, name, description, price);
		this.size = size;
		this.material = material;
		this.availableColors = availableColors;
		this.price=price;
	}
	public String getSize()
	{
		return size;
	}
	public String getMaterial()
	{
		return material;
	}
	public String getColor()
	{
		return availableColors;
	}
	public void displaydetails()
	{
		System.out.println("Size:"+size);
		System.out.println(" material:"+material);
		System.out.println(" colors: "+availableColors);
		System.out.println(" price:"+price);
	}
}
