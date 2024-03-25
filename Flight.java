package Part2;

import java.util.Scanner;

//Flights class
public class Flight {
	
	//Fields
	//flight number
	private String flightNumber;	
	//list of passengers
	MyLinkedList<Passenger> passengers = new MyLinkedList<>();
	//Scanner 
	public static Scanner scan = new Scanner(System.in);
	//The passenger 
	//private static Passenger p = null;
	
	//creating the flight
	private static Flight flight = new Flight("1");
	
	
	private void sysout() {
		// TODO Auto-generated method stub

	}
	
	//constructors
	public Flight(String flightNumber)
	{
		this.flightNumber = flightNumber;
		this.passengers = new MyLinkedList<>();
	}
	
	//mutators 
	public void setFlightNumber(String flightNumber)
	{
		this.flightNumber = flightNumber;
	}
	
	//access
	public String getFlightNumber()
	{
		return flightNumber;
	}
	
	
	
	
	
	//menu method 
	public static int menu()
	{
		//the choice variable
		int option;
			
		
		
		
		
		//prompting the user
		System.out.println("Menu:");
		System.out.println("1. Reserve a ticket");
		System.out.println("2. Cancel a reservation");
		System.out.println("3. Check whether ticket is reserved for a particular person");
		System.out.println("4. Display the passengers");
		System.out.println("5. Check double-bookings");
		System.out.println("6. Exit");
		System.out.println("");
		
		
		
		
		//storing the users choice
		option = scan.nextInt();
			
		//returns the options
		return option;
	}
	
	
	
	
	//reserveTicket method
	public static void reserveTicket()
	{
		//the details of the person
		String id;
		String name;
		String cNumber;
		
		
		
		
		
		//prompting and storing
		System.out.println("Ticket reservation: " + "\n");
		
		
		//prompting and creating the passenger
		Passenger p = createPassenger();
		
		//adding the passenger to the flight
		flight.passengers.append(p);
		
		System.out.println(p.getName() + " you have successfully made a reservation for Flight 1" + "\n");
	}
	
	
	
	
	
	//cancelTicket method
	public static void cancelTicket(MyLinkedList<Passenger> parPassengers)
	{
		//complete boolean
		boolean complete = false;
		Passenger pCancel = null;
		
		
		
				
		while(complete == false)
		{
			//prompting the user to either terminate or book
			System.out.println("Canceling your ticket..." + "\n");
			
			//prompting and creating the passenger
			pCancel = createPassenger();
			
			//Canceling the ticket/removing the passenger from the flight
			complete = parPassengers.delete(pCancel); // this will make complete = true when a passenger is successfully removed
			
			if(complete == false)
			{
				System.out.println("Ivalid credentials, you do not have a ticket for Flight 1");
				//emptying the p1 object
				pCancel = null;
			}
		}
		System.out.println(complete);
		//confirmation message
		System.out.println("You have successfully canceled your booking for Flight 1" + "\n");
	}
	
	
	
	
	
	//checkTicket method
	public static void checkTicket(MyLinkedList<Passenger> parPassengers)
	{
		//checking 
		boolean checking = false;
		
		//heading
		System.out.println("Checking if you made a ticket reservation..." + "\n");
		
		//prompting and creating the passenger
		Passenger pCheck = createPassenger();
		System.out.println("");
		
		System.out.println(checking);
		
		checking  = parPassengers.contains(pCheck);
		
		
		System.out.println(checking);
		if(checking == true)
		{
			System.out.println(pCheck.getName() + " You have an existing reservation for Flight 1");
		}
		else
		{
			System.out.println(pCheck.getName() + " You do not have any reservations for Flight 1");
		}
		//Checking if the passenger has booked for the flight 
		//return checking;
	}
	
	
	
	
	
	//displayPassengers method
	public static void displayPassengers(MyLinkedList<Passenger> parPassengers) {
	    System.out.println("Passenger List:");
	    System.out.println("----------------");
	    
	    // Iterate through the list of passengers and display their details
	    
	    //parPassengers.display();
	   System.out.println(parPassengers.toString() + "\n");
	}
	
	
	

	
	
	
	//Exit method
	public static void exit()
	{
		 System.exit(0);
	}
	
	
	
	
	
	//prompt and create passenger
	public static Passenger createPassenger()
	{
		//the details of the person
		String id;
		String name;
		String cNumber;
				
		
		
		
		
		//prompting the user to either terminate or book
		System.out.println("Enter your details");
		System.out.println("Id: ");
		id = scan.next();
		System.out.println("Name: ");
		name = scan.next();
		System.out.println("Contact Number: ");
		cNumber = scan.next();
		System.out.println("\n");
						
		//creating an object of the passenger
		Passenger p1 = new Passenger(id, name, cNumber);
		
		//returning the passenger
		return p1;
	}
	
	
	
	
	
	
	
	//main method 
	public static void main(String[] args)
	{
		//Testing
		int choice = 0;
		boolean checking = false;
		
		
		
		
		
		//while the choice is not = 6
		while(choice != 6)
		{
			//displaying the menu
			choice = menu();
			System.out.println("\n");
			
			
		 
		    //choosing an option
		    switch (choice) {
		     case 1:
		     	reserveTicket();
		     	break;
		     case 2:
		        cancelTicket(flight.passengers);
		        break;
		     case 3:
		        checkTicket(flight.passengers);
		        
		        break;
		     case 4:
		        displayPassengers(flight.passengers);
		        break;
		     case 5:
		        System.out.println(flight.passengers.checkDouble());  
		        break;
		     case 6:
		        exit();
		        break;
		     default:
		        System.out.println("Invalid choice");
		        break;
		    }
		    
		    System.out.println("\n");
		    System.out.println("What would you like to do next ?");
		    System.out.println("\n");
		}
	}
	
	//Don't get tired, rather do your best in each and everything it is that you do.
	//All the best with tomorrow's test 
}
