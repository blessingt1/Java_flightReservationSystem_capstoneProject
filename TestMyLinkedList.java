package Part2;

//TestMyLinkedList class
public class TestMyLinkedList {

	
	
	//main method
	public static void main(String[] args) {
		
		//creating the flight
		Flight flight = new Flight("1");

		//list of passengers
		MyLinkedList<Passenger> passengers = new MyLinkedList<>();
		MyLinkedList<Passenger> finalPass;
		
		//Testing an empty list
		System.out.println("Check for double bookings from an empty passengers list:" + "\n");
		System.out.println("Empty list:");
		System.out.println(passengers);
		finalPass = passengers.checkDouble();
		System.out.println("After checking: ");
		System.out.println(finalPass + "\n");
		
		
		
		//Testing non existing double bookings
		System.out.println("Check for double bookings from a passenger list with no double/duplicate bookings" + "\n");
		passengers.append(new Passenger("030809", "Blessing", "0812435709"));
		passengers.append(new Passenger("020508", "Tshepo", "0872238967"));
		passengers.append(new Passenger("021207", "Paballo", "0687689980"));
		passengers.append(new Passenger("030709", "Mots", "0669785415"));
		System.out.println("Current passenger list: ");
		System.out.println(passengers + "\n");
		finalPass = passengers.checkDouble();
		System.out.println("After checking: ");
		System.out.println(finalPass + "\n");
		passengers.clear();
		
		
		//Testing with duplicate bookings in the list
		System.out.println("Check for double bookings from a passenger list with double/duplicate bookings" + "\n");
		passengers.append(new Passenger("030809", "Blessing", "0812435709"));
		passengers.append(new Passenger("020508", "Tshepo", "0872238967"));
		passengers.append(new Passenger("021207", "Paballo", "0687689980"));
		passengers.append(new Passenger("030809", "Blessing", "0812435709"));
		
		System.out.println("The current passengers list");
		System.out.println(passengers + "\n");
		finalPass = passengers.checkDouble();
		System.out.println("The passengers list without duplicate bookings");
		System.out.println(finalPass);
		System.out.println("");
	}

}

























