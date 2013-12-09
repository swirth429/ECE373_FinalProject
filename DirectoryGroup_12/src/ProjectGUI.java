/**
 * 
 */

/**
 * @author Steven
 *
 */

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.*;

public class ProjectGUI extends JFrame implements ActionListener {
	private JMenuBar menuBar;
	private JMenu File;
	private JMenu People;
	private JMenu Group;
	private JMenu Event;
	private JMenuItem FileSave;
	private JMenuItem FileLoad;
	private JMenuItem FilePrint;
	private JMenuItem FileExit;
	private JMenuItem PeopleSearch;
	private JMenuItem PeopleCreate;
	private JMenuItem PeopleAddGroup;
	private JMenuItem PeopleAddEvent;
	private JMenuItem PeoplePrint;
	private JMenuItem GroupSearch;
	private JMenuItem GroupCreate;
	private JMenuItem GroupPrint;
	private JMenuItem GroupEdit;
	private JMenuItem EventSearch;
	private JMenuItem EventCreate;
	private JMenuItem EventPrint;
	private JMenuItem EditEventList;
	
	private Business tempBusiness = null;
	private JTextArea textArea;
	
	public ProjectGUI(String title, Business bus)
	{
		super(title);
		
		final int WINDOW_HEIGHT = 350;
		final int WINDOW_WIDTH = 350;
		
		setSize(WINDOW_HEIGHT,WINDOW_WIDTH);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(new JLabel("<HTML>Welcome to the business directory.<BR>Choose an action from the above menus</HTML",JLabel.CENTER)); 
			
		
		tempBusiness = bus;
		
		buildGUI();
		setVisible(true);
		
	}
	
	
	public void buildGUI()
	{
		menuBar = new JMenuBar();
		
		File = new JMenu("File");
		People = new JMenu("People");
		Group = new JMenu("Groups");
		Event = new JMenu("Events");
		
		FileSave = new JMenuItem("Save Directory");
		FileLoad = new JMenuItem("Load Directory");
		FilePrint = new JMenuItem("Print Directory Info");
		FileExit = new JMenuItem("Exit");
		
		FileSave.addActionListener(this);
		FileLoad.addActionListener(this);
		FilePrint.addActionListener(this);
		FileExit.addActionListener(this);
		
		PeopleSearch = new JMenuItem("Search People");
		PeopleCreate = new JMenuItem("Create Person");
		PeoplePrint = new JMenuItem("Print Person List");
		PeopleAddGroup = new JMenuItem("Add person to a group");
		PeopleAddEvent = new JMenuItem("Add person to event");
		
		PeopleSearch.addActionListener(this);
		PeopleCreate.addActionListener(this);
		PeoplePrint.addActionListener(this);
		PeopleAddGroup.addActionListener(this);
		PeopleAddEvent.addActionListener(this);
		
		GroupSearch = new JMenuItem("Search Groups");
		GroupCreate = new JMenuItem("Create Group");
		GroupPrint = new JMenuItem("Print Groups");
		GroupEdit = new JMenuItem("Edit Group Members");
		
		GroupSearch.addActionListener(this);
		GroupCreate.addActionListener(this);
		GroupPrint.addActionListener(this);
		GroupEdit.addActionListener(this);
		
		EventSearch = new JMenuItem("Search Events");
		EventCreate = new JMenuItem("Create Event");
		EventPrint = new JMenuItem("Print Event");
		EditEventList = new JMenuItem("Edit Guest List");
		
		EventSearch.addActionListener(this);
		EventCreate.addActionListener(this);
		EventPrint.addActionListener(this);
		EditEventList.addActionListener(this);
		
		File.add(FileSave);
		File.add(FileLoad);
		File.add(FilePrint);
		File.add(FileExit);
		
		menuBar.add(File);
		
		People.add(PeopleSearch);
		People.add(PeopleCreate);
		People.add(PeoplePrint);
		People.add(PeopleAddGroup);
		People.add(PeopleAddEvent);
		
		menuBar.add(People);
		
		Group.add(GroupSearch);
		Group.add(GroupCreate);
		Group.add(GroupPrint);
		Group.add(GroupEdit);
		
		menuBar.add(Group);
		
		Event.add(EventSearch);
		Event.add(EventCreate);
		Event.add(EventPrint);
		Event.add(EditEventList);
		
		menuBar.add(Event);
		
		setJMenuBar(menuBar);
		
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JMenuItem source = (JMenuItem) e.getSource();
		
		if (source == FileSave)
		{
			tempBusiness.saveData();
		}
		
		if (source == FileLoad)
		{
			tempBusiness = Business.loadData();
		}
		
		if (source == FilePrint)
		{
			HandleFilePrint();
		}
		
		if (source == FileExit)
		{
			System.exit(0);
		}
		
		if (source == PeopleSearch)
		{
			HandlePeopleSearch();
		}
		
		if (source == PeopleCreate)
		{
			HandlePeopleCreate();
		}
		
		if (source == PeoplePrint)
		{
			HandlePeoplePrint();
		}
		
		if (source == PeopleAddGroup)
		{
			HandleGroupAddPerson();
		}
		
		if (source == PeopleAddEvent)
		{
			HandlePersonAddEvent();
		}
		
		if (source == GroupSearch)
		{
			HandleGroupSearch();
		}
		
		if (source == GroupCreate)
		{
			
		}
		
		if (source == GroupPrint)
		{
			
		}
		
		if (source == GroupEdit)
		{
			
		}
		
		if (source == EventSearch)
		{
			
		}
		
		if (source == EventCreate)
		{
			
		}
		
		if (source == EventPrint)
		{
			
		}
		
		if (source == EditEventList)
		{
			
		}
		
				
	}
	
	public void HandleFilePrint()
	{
		JPanel tempPanel = new JPanel();
		textArea = new JTextArea(10,40);
		tempPanel.setLayout(new FlowLayout());		
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);		
		textArea.setEditable(false);
		
		
		
		redirectSystemStreams();				
		tempBusiness.printAll();
		tempPanel.add(scrollPane);
		
		
		JOptionPane.showMessageDialog(this,
				tempPanel,
				"University Info",				
				JOptionPane.PLAIN_MESSAGE);
		
		System.setOut(System.out);
	}
	
	public void HandlePeopleSearch(){
		
		int rslt;
		String name = null;
		
		JPanel tempPanel = new JPanel();
		JPanel tempPanel2 = new JPanel();
		
		tempPanel.setLayout(new GridLayout(1,2));
		
		JLabel nameLabel = new JLabel("Name: ");
		JTextField nameBox = new JTextField(15);
		
		tempPanel.add(nameLabel);
		tempPanel.add(nameBox);
		
		rslt = JOptionPane.showConfirmDialog(this,
				tempPanel,
				"Search People",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		
		if (rslt == JOptionPane.OK_OPTION)
		{
			name = nameBox.getText();
			
			if(name.trim().equals("")) {
				JOptionPane.showMessageDialog(this, 
											"Please enter a valid name", 
											"Error: Please enter a valid name", 
											JOptionPane.PLAIN_MESSAGE);
			}
			
			else if(containsPerson(name) == false)
			{
				JOptionPane.showMessageDialog(this, 
						"Person not found", 
						"Error: Person not found", 
						JOptionPane.PLAIN_MESSAGE);
			}
			
			else if(containsPerson(name) == true)
			{
				JTextArea tArea = new JTextArea();
				Person tempPerson = null;
				
				for (int i=0;i<tempBusiness.getEmployees().size();i++)
				{
					if (name.trim().equals(tempBusiness.getEmployees().get(i).getName()))
					{
						tempPerson = tempBusiness.getEmployees().get(i);
					}
								
				}
				
				for (int i=0; i < tempBusiness.getCustomers().size();i++)
				{
					if (name.trim().equals(tempBusiness.getCustomers().get(i).getName()))
					{
						tempPerson = tempBusiness.getCustomers().get(i);
					}
				}
				
								
				redirectSystemStreams();
				
				tempPerson.print();
				
				tempPanel2.add(tArea);
				JOptionPane.showMessageDialog(this, 
						tempPanel2, 
						"Person was found!", 
						JOptionPane.PLAIN_MESSAGE);
				System.setOut(System.out);
			}
		}
	}
	
	public void HandlePeopleCreate()
	{
		int rslt;
		String name = null;
		String phone = null;
		String email = null;
		
		JRadioButton selectEmp = new JRadioButton("Employee");
		selectEmp.setSelected(true);
		JRadioButton selectCust = new JRadioButton("Customer");
			
		ButtonGroup group = new ButtonGroup();
		
		group.add(selectEmp);
		group.add(selectCust);
		
		Person newPerson = null;
		
		JPanel tempPanel = new JPanel();		
		JPanel tempPanel2 = new JPanel();
		
		tempPanel.setLayout(new GridLayout(4,2));
		
		JLabel nameLabel = new JLabel("Name: ");
		JLabel phoneLabel = new JLabel("Phone Number: ");
		JLabel emailLabel = new JLabel("Email: ");
		JTextField nameBox = new JTextField(15);
		JTextField phoneBox = new JTextField(15);
		JTextField emailBox = new JTextField(15);
		
		tempPanel.add(selectEmp);
		tempPanel.add(selectCust);
		tempPanel.add(nameLabel);
		tempPanel.add(nameBox);
		tempPanel.add(phoneLabel);
		tempPanel.add(phoneBox);
		tempPanel.add(emailLabel);
		tempPanel.add(emailBox);
		
		rslt = JOptionPane.showConfirmDialog(this,
				tempPanel,
				"Create Person",
				JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		
		if (rslt == JOptionPane.OK_OPTION)
		{
			name = nameBox.getText();
			phone = phoneBox.getText();
			email = emailBox.getText();
			
			if(name.trim().equals("")) {
				JOptionPane.showMessageDialog(this, 
											"Please enter a valid name", 
											"Error: Please enter a valid name", 
											JOptionPane.PLAIN_MESSAGE);
			}
			
			else if(phone.trim().equals("")) {
				JOptionPane.showMessageDialog(this, 
											"Please enter a phone number", 
											"Error: Please enter a phone number", 
											JOptionPane.PLAIN_MESSAGE);
			}
			
			else if(email.trim().equals("")) {
				JOptionPane.showMessageDialog(this, 
											"Please enter an email address", 
											"Error: Please enter an email", 
											JOptionPane.PLAIN_MESSAGE);
			}
			
			else if(containsPerson(name) == true)
			{
				JOptionPane.showMessageDialog(this, 
						"Person already exists!", 
						"Error: Person found", 
						JOptionPane.PLAIN_MESSAGE);
			}
			
			else if(containsPerson(name) == false)
			{
				if(selectEmp.isSelected() == true)
				{
					newPerson = new Employee();
					newPerson.setName(name);
					newPerson.setPhone(phone);
					newPerson.setEmail(email);
				}
				
				else 
				{
					newPerson = new Customer();
					newPerson.setName(name);
					newPerson.setPhone(phone);
					newPerson.setEmail(email);
				}
			}
			
			
		}
	}
	
	public void HandlePeoplePrint()
	{
		JPanel tempPanel = new JPanel();
		textArea = new JTextArea(10,40);
		tempPanel.setLayout(new FlowLayout());		
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);		
		textArea.setEditable(false);
						
		redirectSystemStreams();				
		
		System.out.println("List of customers: \n");
		
		for (int i=0; i<tempBusiness.getCustomers().size(); i++)
		{
			System.out.println(tempBusiness.getCustomers().get(i).getName());
		}
		
		for (int i=0; i<tempBusiness.getEmployees().size(); i++)
		{
			System.out.println(tempBusiness.getEmployees().get(i).getName());
		}
		
		
		tempPanel.add(scrollPane);
				
		JOptionPane.showMessageDialog(this,
				tempPanel,
				"List of people",				
				JOptionPane.PLAIN_MESSAGE);
		
		System.setOut(System.out);
	}
	
	public void HandleGroupAddPerson()
	{
		HandlePeopleSearch();
		
	}
	
	public void HandlePersonAddEvent()
	{
		
	}
	
	public void HandleGroupSearch()
	{
		
	}
	
	public boolean containsPerson(String name){
		boolean customer = false;
		boolean employee = false;
		
		
		for (int i=0;i<tempBusiness.getEmployees().size();i++)
		{
			if (name.trim().equals(tempBusiness.getEmployees().get(i).getName()))
			{
				employee = true;
			}
						
		}
		
		for (int i=0; i < tempBusiness.getCustomers().size();i++)
		{
			if (name.trim().equals(tempBusiness.getCustomers().get(i).getName()))
			{
				customer = true;
			}
		}
		
		if(employee == true || customer == true)
		{
			return true;
		}
		
		return false;
	}
	
	
	
	
	
	private void updateTextArea(final String text) {
	    SwingUtilities.invokeLater(new Runnable() {
	      public void run() {
	        textArea.append(text);
	      }
	    });
	  }

	  private void redirectSystemStreams() {
	    OutputStream out = new OutputStream() {
	      @Override
	      public void write(int b) throws IOException {
	        updateTextArea(String.valueOf((char) b));
	      }

	      @Override
	      public void write(byte[] b, int off, int len) throws IOException {
	        updateTextArea(new String(b, off, len));
	      }

	      @Override
	      public void write(byte[] b) throws IOException {
	        write(b, 0, b.length);
	      }
	    };

	    System.setOut(new PrintStream(out, true));
	    System.setErr(new PrintStream(out, true));
	  }
	  

}
