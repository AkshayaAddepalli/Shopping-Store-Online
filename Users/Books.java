package Users;

public class Books extends ProductClass{
	protected int productId;
	protected String name;
	protected String description;
	protected String genre;
	protected String author;
	protected double price;
	public Books(int productId,String name,String description,double price,String genre,String author)
	{
		super(productId,name,description,price);
		this.productId=productId;
		this.name=name;
		this.description=description;
		this.genre=genre;
		this.author=author;
		this.price=price;
	}
	public String getGenre()
	{
		return genre;
	}
	public void displaydetails()
	{
		System.out.println("Book name :"+name);
		System.out.println(" description:"+description);
		System.out.println(" genre: "+genre);
		System.out.println(" author: "+ author);
		System.out.println(" price:"+price);
	}

}
