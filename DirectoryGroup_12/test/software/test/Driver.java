package software.test;
// Richard Gonzales, Steven Wirth
// ECE 373
// Directory_Group 12 Driver

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import people.*;
import software.*;

public class Driver{
	public static void main(String[] args) {
		Business biz1 = new Business();
		BusinessGUI newGUI;
		
		// Create Business of employees, customers, groups and events
		
		// Set employees
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		
		// Set customers
		Customer cust1 = new Customer();
		Customer cust2 = new Customer();
		
		// Set groups
		ProjectGroup pg1 = new ProjectGroup();
		ProjectGroup pg2 = new ProjectGroup();
		
		// Set events
		Event event1 = new Event();
		Event event2 = new Event();
		
		// Set attributes
		biz1.setName("The Biz");
		
		emp1.setName("Steven");
		emp1.setPhone("1234567890");
		emp1.setEmail("steven@biz.com");
		emp1.setTitle("CoFounder");
		
		emp2.setName("Richard");
		emp2.setPhone("2345678901");
		emp2.setEmail("richard@biz.com");
		emp2.setTitle("CoFounder");
		
		cust1.setName("Jack");
		cust1.setPhone("1237894560");
		cust1.setEmail("jack@domain.com");
		cust1.setLead(emp1);
		
		cust2.setName("Jill");
		cust2.setPhone("1112223344");
		cust2.setEmail("jill@domain2.com");
		cust2.setLead(emp2);
		
		pg1.setName("Steven's Project Group");
		pg1.getEmployees().add(emp1);
		pg1.getCustomers().add(cust1);
		
		pg2.setName("Richard's Project Group");
		pg2.getEmployees().add(emp2);
		pg2.getCustomers().add(cust2);
		
		event1.setName("Biz Event");
		event1.setLocation("Biz Office");
		event1.addAttendee(emp1);
		event1.addAttendee(emp2);
		event1.addAttendee(cust1);
		event1.addAttendee(cust2);
		
		event2.setName("Super Secret Surprise Party");
		event2.setLocation("Courtyard");
		event2.addAttendee(emp1);
		event2.addAttendee(emp2);
		event2.addAttendee(cust1);
		event2.addAttendee(cust2);
		
		// Add to instance of business
		biz1.employees.add(emp1);
		biz1.employees.add(emp2);
		
		biz1.customers.add(cust1);
		biz1.customers.add(cust2);
		
		biz1.projectGroups.add(pg1);
		biz1.projectGroups.add(pg2);
		
		biz1.events.add(event1);
		biz1.events.add(event2);
		
		// Instantiate GUI
		newGUI = new BusinessGUI(biz1.getName(), biz1);
		
	}
}