package Users;

public class Snacks extends ProductClass{
	protected int productId;
	protected String name;
	protected String description;
	protected String type;
	protected double price;
	public Snacks(int productId,String name,String description,double price,String type)
	{
		super(productId,name,description,price);
		this.productId=productId;
		this.name=name;
		this.description=description;
		this.type=type;
		this.price=price;
	}
	public String gettype()
	{
		return type;
	}
	public void displaydetails()
	{
		System.out.println("Snack name :"+name);
		System.out.println(" description:"+description);
		System.out.println(" type: "+type);
		System.out.println(" price:"+price);
	}
}
