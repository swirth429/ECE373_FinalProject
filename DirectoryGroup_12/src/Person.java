import java.util.ArrayList;


public class Person {

	String name;
	String phone;
	String email;
	ArrayList <ProjectGroup>groups = new ArrayList <ProjectGroup>();
	ArrayList <Event>schedule = new ArrayList <Event>();
	
	
	public Person()
	{
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String Name)
	{
		name = Name;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String Phone)
	{
		phone  = Phone;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String Email)
	{
		email = Email;
	}
	
	public ArrayList <ProjectGroup> getGroups()
	{
		return groups;
	}
	
	public void addGroup(ProjectGroup group)
	{
		groups.add(group);
	}
	
	public ArrayList <Event> getSchedule()
	{
		return schedule;
	}
	
	public void addEvent (Event event)
	{
		schedule.add(event);
	}
	
	public void print()
	{
		System.out.println(name);
	}
	
	public void printContactInfo()
	{
		System.out.println("Name: "+name);
		System.out.println("Phone Number: " + phone);
		System.out.println("Email: "+ email);
	}
	
	public void printSchedule()
	{
		for (int i=0; i<schedule.size();i++)
		{
			schedule.get(i).print();
		}
	}
	
	public void PrintGroups()
	{
		System.out.println("Person is in the following groups: ");
		for (int i=0; i<groups.size();i++)
		{
			groups.get(i).print();
		}
	}
	
	
}
