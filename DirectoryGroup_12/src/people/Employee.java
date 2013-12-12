package people;

public class Employee extends Person{
	String title;
	
	public Employee()
	{
		super();
		title = null;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String Title)
	{
		title = Title;
	}

}
