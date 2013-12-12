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
		
		// TODO
		// Set attributes
		
		// Add to instance of business
		biz1.employees.add(emp1);
		biz1.employees.add(emp2);
		
		biz1.customers.add(cust1);
		biz1.customers.add(cust2);
		
		biz1.projectGroups.add(pg1);
		biz1.projectGroups.add(pg2);
		
		biz1.events.add(event1);
		biz1.events.add(event2);
		
		// TODO
		// test methods within classes
		
		// Instantiate GUI
		newGUI = new BusinessGUI("BusinessGUI", biz1);
		
	}
}