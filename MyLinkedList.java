package Part2;

//our myLinked list outer class
public class MyLinkedList<E>  {
	  private Node<E> head, tail;
	 
	  public MyLinkedList() {
	     head = null;
		 tail = null;
	  }

	  /** Return the head element in the list */
	  public E getFirst() {
	    if (head == null) {
	      return null;
	    }
	    else {
	      return head.element;
	    }
	  }

	  /** Return the last element in the list */
	  public E getLast() {
	    if (head==null) {
	      return null;
	    }
	    else {
	      return tail.element;
	    }
	  }

	  /** Add an element to the beginning of the list */
	  public void prepend(E e) {
	    Node<E> newNode = new Node<>(e); // Create a new node
	    newNode.next = head; // link the new node with the head
	    head = newNode; // head points to the new node
	   
	    if (tail == null) // the new node is the only node in list
	      tail = head;
	  }

	  /** Add an element to the end of the list */
	  public void append(E item) {
	    
		Node<E> newNode = new Node<>(item); // Create a new for element e

	    if (head == null) {
	      head = tail = newNode; // The new node is the only node in list
	    }
	    else {
	      tail.next = newNode; // Link the new with the last node
	      tail = newNode; // tail now points to the last node
	    }
	  }

	  
	  /** Remove the head node and
	   *  return the object that is contained in the removed node. */
	public E removeFirst() {
	    if (head == null) {
	      return null;
	    }
	    else {
	      E temp = head.element;
	      head = head.next;
	      if (head == null) {
	        tail = null;
	      }
	      return temp;
	    }
	}


	//inner class: Node
	private static class Node<E> {
	    E element;
	    Node<E> next;

	    public Node(E element) {
	      this.element = element;
		  next = null;
	    }
	}
	//delete 
	public boolean delete(E item)
	{
		   Node<E> ptr = head;
		   Node<E> prvPtr = null;
		   while (ptr!= null&& ((Comparable<E>)ptr.element).compareTo(item)!= 0)
		   {
			   prvPtr=ptr;
			   ptr=ptr.next;
		   }
		   if (ptr == null)//item not found
		   {
			   return false;
		   }
		   if (ptr==head) // item is first element
		   {
			   head= head.next;
		   }
		   else // general case
		   {
			   prvPtr.next=ptr.next;
		   }
		   if (ptr==tail)// last element
		   {
			   tail=prvPtr;
		   }
		   return true;
	}
	//toString 
	public String toString() {
		String result = "[";

	    Node<E> ptr = head;
	    for (ptr= head;ptr!=null; ptr=ptr.next) 
		{
			 result = result +  ptr.element.toString();     
			 if (ptr.next != null)
	             result = result + ","; // add commas but not to the final 1   
		}
	    result += "]"; // Insert the closing ] in the string
	    return result;
	}


	public void clear() {
	     head = tail = null;
	}


	
	  
	  
	  
	  
	  
	  
	  
	//contains method
	public boolean contains(E item)
	{
		//Creating the pointer
		Node<E> ptr = head;
		   
		//traversing through the LinkedList
		for(ptr = head; ptr!=null; ptr=ptr.next)
		{
			//if the address of the person = ptr
			//if(item.equals(ptr) == true)//checking if object if in the array  
			if(((Comparable<E>)ptr.element).compareTo(item) == 0)
			{
				return true;//if equals, return true
			} 
		}//else return false
		return false;
	}
	
	
	
	
	
	//checkDouble method
	public MyLinkedList<E> checkDouble() {
		
		//creating a list of passengers
	    MyLinkedList<E> finalPassengers = new MyLinkedList<>(); // Create a new list for unique passengers
	    //creating a ptr and equating it to the head
	    Node<E> ptr = head;

	    //while we are still in the loop...
	    //while the pointer is not null, do the following
	    while (ptr != null) {
	        //Check if the current passenger is not already in the finalPassengers list
	        if (!finalPassengers.contains(ptr.element))
	        {
	        	finalPassengers.append(ptr.element); // Append the final passenger to the new list
	        }
	        //moving on to the next, and the next, and the next...
	        ptr = ptr.next;
	    }

	    //returning the final list of passengers
	    return finalPassengers;
	}	
	
	
	
	
	
	
	//create a method 
	//getMissing method
	
	
	
	//For the method getMissing, return the objects from the calling list that are missing/excluded in the parameter list.
	
	public MyLinkedList<E> getMissing(MyLinkedList<E> parList)
	{
		//our pointers
		Node<E> callPtr = head; //calling list pointer 
		Node<E> parPtr = parList.head; //parameter list pointer
		
		//our return list
		MyLinkedList<E> returnList = new MyLinkedList<E>();
		
		//check for your special cases
		//case 1: calling list is empty 
		if(head == null)
		{
			return null;//return null for empty list
		}
		
		//case 2: parameter list is empty 
		if(parList.head == null)//if the parameter list is empty, we then know that all the elements in the calling list are not within the parameter list, therefore return all the 
								//nodes/objects of the calling list by using the statement: return this;
		{
			return this;//return the calling list
		}
		
		//if both lists are empty, we return null
		if(head == null && parList.head == null)
		{
			return null;
		}
		
		
		//general case: missing node is identified in the calling list(element from calling list is excluded from the parameter list
		while(callPtr != null)//do take note that the calling pointer is currently = the calling list head.
		{
			//found boolean 
			boolean found = false;
			
			//comparing the ptr of the calling list to the ptr of the parameter list.
			for(parPtr = parList.head; parPtr != null; parPtr = parPtr.next)
			{
				if(callPtr.element.equals(parPtr.element))
				{
					found = true;
					break;
				}
			}
			
			if(!found)
			{
				returnList.append(callPtr.element);
			}
				
			callPtr = callPtr.next;
		}
		
		//return the returnList
		return returnList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	//for loop to traverse through the list
	for(parPtr = parList.head; parPtr != null; parPtr = parPtr.next)
	{
		//comparing the ptr of the calling list to the ptr of the parameter list.
		if(callPtr.element == parPtr.element)
		{
			
		}
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
	   
} // end myLinkedList class

