import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Steven
 *
 */
public class ProjectGroup {
	
	String name;
	ArrayList <Employee> employees = new ArrayList <Employee>();
	ArrayList <Customer> customers = new ArrayList <Customer>();
	
	public ProjectGroup()
	{
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String str)
	{
		name = str;
	}
	
	public ArrayList<Employee> getEmployees()
	{
		return employees;
	}

	public ArrayList<Customer> getCustomers()
	{
		return customers;
	}
	
	public void print()
	{
		System.out.println(name);
	}
	
	
}
