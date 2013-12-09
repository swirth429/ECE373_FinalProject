// Richard Gonzales, Steven Wirth
// ECE 373
// Directory Group 12 - Final Project

//package 

import java.util.ArrayList;

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

	public void printAll(){
		printEmployees();
		printCustomers();
		printProjectGroups();
		printEvents();
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
