package software;
/**
 * 
 */
import java.util.ArrayList;
import software.*;
import people.*;
/**
 * @author Steven
 *
 */
public class Event {
	
	String name;
	String location;
	ArrayList<Person> attendees = new ArrayList<Person>();
	
	public Event()
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
	
	public String getLocation()
	{
		return location;
	}
	
	public void setLocation(String str)
	{
		location = str;
	}
	
	public void addAttendee(Person per)
	{
		//TODO Add check to see if person is already on list
		attendees.add(per);
	}
	
	public ArrayList <Person> getAttendees()
	{
		return attendees;
	}
	
	public void print()
	{		
			System.out.println("Event Name: "+name);
			System.out.println("Event Location: "+location);
			System.out.println("\nEvent Attendees: \n");
			
		
	}
	
	public void printAttendees()
	{
		for(int i =0; i<attendees.size();i++)
		{
			attendees.get(i).print();
		}
	}
	
}
