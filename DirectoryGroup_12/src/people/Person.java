package people;

import java.util.ArrayList;
import software.*;


public class Person {

	String name;
	String phone;
	String email;
	ArrayList <ProjectGroup>groups;
	ArrayList <Event>schedule;
	
	
	public Person()
	{
		name = null;
		phone = null;
		email = null;
		groups  = new ArrayList <ProjectGroup>();
		schedule = new ArrayList <Event>();
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
		System.out.println("Name: "+this.name);
		System.out.println("Phone Number: " + this.phone);
		System.out.println("Email: "+ this.email);
	}
	
	public void printSchedule()
	{
		for (int i=0; i<schedule.size();i++)
		{
			this.schedule.get(i).print();
		}
	}
	
	public void PrintGroups()
	{
		System.out.println("Person is in the following groups: ");
		for (int i=0; i<this.groups.size();i++)
		{
			groups.get(i).print();
		}
	}
	
	public void PrintEvents()
	{
		System.out.println("Person is in the following Events: ");
		for (int i=0; i<this.schedule.size();i++)
		{
			this.schedule.get(i).print();
		}
	}
	
	
}
