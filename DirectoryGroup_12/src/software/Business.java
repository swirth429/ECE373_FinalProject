// Richard Gonzales, Steven Wirth
// ECE 373
// Directory Group 12 - Final Project

//package 

package software;

import java.util.ArrayList;

import people.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Business implements Serializable{

	// Fields
	private String name;
	public ArrayList<Employee> employees;
	public ArrayList<Customer> customers;
	public ArrayList<ProjectGroup> projectGroups;
	public ArrayList<Event> events;
	
	// Methods
	
	/// Default Constructor
	public Business(){
		name = null;
		employees = new ArrayList<Employee>();
		customers = new ArrayList<Customer>();
		projectGroups = new ArrayList<ProjectGroup>();
		events = new ArrayList<Event>();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String newName){
		name = newName;
	}
	
	public ArrayList<Employee> getEmployees(){
		return employees;
	}
	
	public ArrayList<Customer> getCustomers(){
		return customers;
	}
	
	public ArrayList<ProjectGroup> getProjectGroups(){
		return projectGroups;
	}
	
	public ArrayList<Event> getEvents(){
		return events;
	}
	
	public void printEmployees(){
		int i;
		int size = employees.size();
		
		for(i = 0; i < size; i++){
			employees.get(i).print();
		}
	}
	
	public void printCustomers(){
		int i;
		int size = customers.size();
		
		for(i = 0; i < size; i++){
			customers.get(i).print();
		}
	}
	
	public void printProjectGroups(){
		int i;
		int size = projectGroups.size();
		
		for(i = 0; i < size; i++){
			projectGroups.get(i).print();
		}
	}
	
	public void printEvents(){
		int i;
		int size = events.size();
		
		for(i = 0; i < size; i++){
			events.get(i).print();
		}
	}
	
	public void addEmployee(Employee emp)
	{
		//TODO see if employee already exists in database
		this.employees.add(emp);
	}
	
	public void addCustomer(Customer cust)
	{
		//TODO see if customer already exists in database
		this.customers.add(cust);
	}

	public void printAll(){
		System.out.println("Business Name: " + name);
		
		System.out.println("\nEmployees:");
		printEmployees();
		
		System.out.println("\nCustomers: ");
		printCustomers();
		
		System.out.println("\nProject Groups:");
		printProjectGroups();
		
		System.out.println("\nEvents:");
		printEvents();
	}
	
	/*
	 * returns true if name matches somebody in the database
	 * returns false is there are no matches in the database
	 */
	public boolean containsPerson(String name){
		boolean customer = false;
		boolean employee = false;
		
		
		for (int i=0; i < employees.size(); i++){
			if (name.trim().equalsIgnoreCase(employees.get(i).getName())){
				employee = true;
			}				
		}
		
		for (int i=0; i < customers.size();i++){
			if (name.trim().equalsIgnoreCase(customers.get(i).getName())){
				customer = true;
			}
		}
		
		if(employee == true || customer == true){
			return true;
		}
		
		return false;
	}
	
	/*
	 * returns the Person that matches the name
	 * returns null if there is no match
	 */
	public Person findPerson(String name){
		Person pers = null;
		
		for (int i=0; i < employees.size(); i++){
			if (name.trim().equalsIgnoreCase(employees.get(i).getName())){
				pers = employees.get(i);
				return pers;
			}				
		}
		
		for (int i=0; i < customers.size();i++){
			if (name.trim().equalsIgnoreCase(customers.get(i).getName())){
				pers = customers.get(i);
				return pers;
			}
		}
		
		return pers;
	}

	public void saveData(){
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;
		
		try{
			fileOut = new FileOutputStream("business.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(this);
		}
		
		catch(IOException i){
			i.printStackTrace();
		}
			
	}

	public static Business loadData(){
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		Business biz = null;
		
		try{
			fileIn = new FileInputStream("business.ser");
			objIn = new ObjectInputStream(fileIn);
			biz = (Business)objIn.readObject();
			objIn.close();
			fileIn.close();
		}
		
		catch(IOException i){
			i.printStackTrace();
		}
		
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return biz;
	}

		
	}
