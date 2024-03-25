package Part2;

//passenger class
public class Passenger implements Comparable<Passenger>{

	
	//Fields 
	
	//id
	private String id;
	//lastName 
	private String name;
	//cNumber
	private String cNumber;
	
	
	
	//constructor
	public Passenger(String id, String name, String cNumber)
	{
		this.id = id;
		this.name = name;
		this.cNumber = cNumber;
	}
	
	//mutator 
	//id
	public void setId(String id)
	{
		this.id = id;
	}
	//name
	public void setName(String name)
	{
		this.name = name;
	}
	//contactNumber 
	public void setCNumber(String cNumber)
	{
		this.cNumber = cNumber;
	}
	
	//accessor
	//id
	public String getId()
	{
		return id;
	}
	//name
	public String getName()
	{
		return name;
	}
	//name
	public String getcNumber()
	{
		return cNumber;
	}
	
	
	
	//compareTo method
	public int compareTo()
	{
		
		return 0;
	}
	
	
	
	//toString method
	public String toString()
	{
		//returning the name
		return "ID: " + getId() + ", " + "Name: " + getName() + ", " + "Contact Number: " + getcNumber() + "\n";
		//return getName();
	}
	
	
	
	//main method 
	public static void main(String args)
	{
		
	}

	@Override
	public int compareTo(Passenger other) {
		if(this.getId().compareTo(other.getId()) == 0 && this.getName().compareTo(other.getName()) == 0 && this.getcNumber().compareTo(other.getcNumber()) == 0)
		{
			return 0;
		}
		//return this.getId().compareTo(other.getId());
		return 1;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Passenger other = (Passenger) obj;
	    return this.id.equals(other.getId());
	}
	
}
