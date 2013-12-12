package people;


public class Customer extends Person{
	
	Employee leadEmployee;
	
	public Customer()
	{
		
	}
	
	public Employee getLead()
	{
		return leadEmployee;
	}
	
	public void setLead(Employee emp)
	{
		leadEmployee = emp;
	}
	
	

}
