package Users;


public class ElectronicProduct extends ProductClass {
	
	
	protected String brand;
	protected String model;
	protected int warrantyPeriod;
	protected double price;

    public ElectronicProduct(int productID, String name, String description, double price, String brand, String model, int warrantyPeriod) {
    	super(productID, name, description, price);
    	this.brand = brand;
    	this.model = model;
    	this.warrantyPeriod = warrantyPeriod;
    	this.price=price;
}
    public String getBrand()
    {
    	return brand;
    }
    public String getModel()
    {
    	return model;
    }
    public void displaydetails()
	{
		System.out.println("Brand name :"+brand);
		System.out.println(" model:"+model);
		System.out.println(" warranty Period: "+warrantyPeriod);
		System.out.println(" price:"+price);
	}

}
