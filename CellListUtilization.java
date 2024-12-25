
// ------------------------------------------------------------
// Comp249
// Assignment 3
// Part 2
// Due date: December 5th 2022
// Written by: Asim Rahman 40207553 & Gianluca Girardi 40228370
// ------------------------------------------------------------
package Part2;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;


/**
 * The CellPhone class has the attributes serialNum (long type), a brand (String type), a year (int type, which indicates manufacturing year) and a price (double type). 
 * It is also assumed that all cellular phones follow one system of assigning serial numbers
 * 
 * @author Asim Rahman and Gianluca Girardi
 * @version 1
 * 
 *
 */
class  CellPhone{
	private long serialNum;
	private String brand;
	private int year;
	private double price;
	
	/**An accessor method to retrieve the serial number
	 * 
	 * @return serialNum for the serial number, which is a long
	 */
	public long getSerialNum() {
		return serialNum;
	}
	
	/**
	 * A mutator value to set the value of serial number
	 * 
	 * @param serialNum, the serial number, which is a long value
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}
	
	/** Accessor method to retrieve the value of brand
	 * 
	 * @return brand, which is a String value
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Mutator value to set the value of brand
	 * @param brand, a string value
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Accessor method to retrieve the value of year
	 * @return year, an integer value
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Mutator value to set the value of year
	 * @param year, an integer value
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * Accessor method to retrieve the value of price
	 * @return price, a double value
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Mutator value, to set the value the value of price
	 * @param price, a double value
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Parameterized constructor that accepts four values and initializes serialNum, brand, year and price to these passed values
	 * 
	 * @param serialNum, a long value
	 * @param brand, a String value
	 * @param year, an integer value
	 * @param price, a double value
	 */
	public CellPhone(long serialNum, String brand, int year, double price) {  
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}
	
	/**
	 * Copy constructor, which takes two parameters, a CellPhone object and a long value(serial number). The newly created object will be assigned all the attributes of the passed object, with the exception of the serial number. serialNum is assigned the value passed as the second parameter to the constructor.
	 * @param cell, a CellPhone object
	 * @param serialNb, a long value
	 */
	public CellPhone(CellPhone cell, long serialNb) {  
		setBrand(cell.brand);
		setYear(cell.year);
		setPrice(cell.price);
		serialNum = serialNb;
	}
	
	/**
	 * clone() method. This method will prompt the user to enter a new serial number, then creates and returns a clone of the calling object with the exception of the serial number, which is assigned the value entered by the user
	 * 
	 */
	public CellPhone clone() {								
		System.out.println("Please enter a serial number");
		Scanner input = new Scanner(System.in);
		long sn = input .nextLong();	
		
		return new CellPhone(this, sn);
		
	}
	
	/**
	 * an equals() methods. Two cell phones are equal if they have the same attributes, with the exception of the serial number, which could be different. 
	 * 
	 */
	public boolean equals(Object obj) {                    
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CellPhone other = (CellPhone) obj;
		return brand.equals(other.brand)
				&& price == other.price && year == other.year;
	}
	
	/**
	 * toString method which shows the serial number, the brand, the price and the year.
	 */
	public String toString() {														
		return "[" + serialNum + ":" + brand + " "+price+ "$" + " " + year +"]" ;
	}
	
}

/**
 *The CellList class. this class has the following:
 *(a) An inner class called CellNode
 *(b) A private attribute called head, which should point to the first node in this list object;
 *(c) A private attribute called size, which always indicates the current size of the list (how many nodes are in the list);
 *(d) A default constructor, which creates an empty list;
 *(e) A copy constructor, which accepts a CellList object and creates a copy of it;
 *(f) A method called addToStart()
 *(g) A method called insertAtIndex()
 *(h) A method called deleteFromIndex()
 *(i) A method called deleteFromStart()
 *(j) A method called replaceAtIndex()
 *(k) A method called find()
 *(l) A method called contains()
 *(m) A method called showContents()
 *(n) A method called equals()
 *
 * 
 * @author Asim Rahman and Gianluca Girardi
 * @version 1
 * 
 *
 */

/**
 * An inner class called CellNode. This class has the following:
 *i. Two private attributes: an object of CellPhone and a pointer to a CellNode object;
 *ii. A default constructor, which assigns both attributes to null;
 *iii. A parameterized constructor that accepts two parameters, a CellPhone object and a 
 *CellNode object, then initializes the attributes accordingly; 
 *iv. A copy constructor;
 *v. A clone() method;
 *vi. Other mutator and accessor methods.
 *
 *@author Asim Rahman and Gianluca Girardi
 * @version 1
 *
 */
class  CellList{
	public class CellNode{     // inner class CellNode
		private CellPhone cell;   // an object of CellPhone
		private CellNode next;	  //a pointer to a CellNode object	
		
		/**
		 * A default constructor, which assigns both attributes to null;
		 * 
		 */
		public CellNode() {			
			this.cell = null;
			this.next = null;
		}
		
		/**
		 * A parameterized constructor that accepts two parameters, a CellPhone object and a CellNode object, then initializes the attributes accordingly
		 * 
		 * @param cell, a CellPhone object
		 * @param next, CellNode object
		 */
		public CellNode(CellPhone cell, CellNode next) {    
			this.cell = cell;
			this.next = next;
		}
		
		
		/**
		 * A copy constructor that uses the clone method to copy the cellPhone object cell from a CellNode
		 * 
		 * @param cn, a CellNode object
		 */
		public CellNode(CellNode cn)					
		{
		cell = cn.cell.clone(); // Deep copy the Cell contents of the node
		next = cn.next;			// the pointer next is assigned the pointer next of the CellNode object cn
		}
		
		
		/**
		 * clone method
		 */
		public CellNode clone() {					
			return new CellNode(this);
		}
		
		/**
		 * An accessor method to retrieve the value of cell, a CellPhone object
		 * @return cell, a CellPhone object
		 */
		public CellPhone getCell() {
			return cell;
		}
		
		/**
		 * A mutator value to retrieve the value of CellPhone object
		 * 
		 * @param cell, a CellPhone object
		 */
		public void setCell(CellPhone cell) {
			this.cell = cell;
		}
		
		/**
		 * An accessor value to retrieve the value of next
		 * 
		 * @return next, a CellNode object
		 */
		public CellNode getNext() {
			return next;
		}
		
		/**
		 * A mutator value, to retrieve the value of next(a CellNode object)
		 * @param next, a CellNode object
		 */
		public void setNext(CellNode next) {
			this.next = next;
		}
		
	} //End of inner class CellNode
	
	private CellNode head; 		//A private attribute called head, which should point to the first node in this list object
	private int size;			//A private attribute called size, which always indicates the current size of the list (how many nodes are in the list)
	
	/**
	 * //A default constructor, which creates an empty list
	 * 
	 */
	public CellList()			
	{
	head = null;				
	size = 0;
	}
	
	
	/**
	 * A copy constructor, which accepts a CellList object and creates a copy of it
	 * 
	 * @param L1, a CellList object
	 */
	public CellList(CellList L1) { 			
		size =0;
		if(L1.head == null) {				// if the CellList L1 is empty so no nodes are present
			head = null;					// then the copy is empty by having head as null
		}
		else {
			head = null;				// start with an empty list
			CellNode t1, t2, t3;		// create 3 temporary pointers (t1 is a pointer to keep track of the node of L1, t2 is a pointer to keep track of the last node of the new list that is being created, t3 is to keep track of the new node in the new list being created)
			
			t1 = L1.head;				//t1 points to the head of L1
			t2 = t3 = null;				//t2 and t3 are not yet assigned any values
			while(t1!=null) {			// a node exists in the given list L1
				if (head == null) { //this only happens once, since the head will be null only before creating the list
					t2 = new CellNode(t1);		//t2 is a pointer to keep track of the last node of the new list that is being created. It creates a new node with a copy constructor that passes the pointer t1 as a parameter and t1 is currently pointing to the head of L1
					head = t2;					// the head is t2 which is the 1st new node created, which is the
					size++;						// the size is increased since we have just created a new node which is the head
				}
				else {							// new list is not empty.
												
					t3 = new CellNode(t1);		//t3 creates a new node with a copy constructor that passes the pointer t1
					t2.next = t3;				//link t2 to t3
					t2 = t3;					// then move t2 to the t3 node
					size++;						//size is increased since a new node t3 is created, t2 is linked to t3 and t2 is moved to t3
				}
				t1 = t1.next;					//t1 is moved to next node in the list L1
			}
			t2 = t3 = null;					// t1 is already null by now
		}
	}
	
	/**
	 *  A method that adds an node to the start of the list
	 *  
	 * @param c, a CellPhone object
	 */
	public void addToStart(CellPhone c){		// accepts one parameter, an object from CellPhone class. The method then creates a node with that passed object and inserts this node at the head of the list
	CellNode n = new CellNode(c, head); 	 // Creating a new node n with CellPhone c at head.  "next" of this new node to point to head
	head = n;								// Now move "head" to point to this new added node
	n = null;								// After head points to n(pointer to new node created), n is then null
	size++;									// size is increased since we added a new node at the start, which is now the new head
	}
	
	/**
	 * A method that creates a node with the passed CellPhone object and inserts this node at the given index if the value of index is valid.	
	 * @param cellP, a CellPhone object
	 * @param index, an integer value
	 * @return true, if inserted
	 * @return false, if not inserted
	 */
	public boolean insertAtIndex(CellPhone cellP, int index) {		//accepts two parameters, an object from 
																	//CellPhone class, and an integer representing an index. 
		
		try {														//If the index is not valid (a valid index 
																	//must have a value between 0 and size-1), the method must throw a 
																	//NoSuchElementException and terminate the program.
																	// If the index is valid, then the method 
																	//creates a node with the passed CellPhone object and inserts this node at the given index.	
			if(index<0 || index>size-1)										
				throw new NoSuchElementException("index does not exist");
		}
		catch(NoSuchElementException e) {
			String errorMessage = e.getMessage();
			System.out.println(errorMessage);
			System.out.println("terminating the program");
			System.exit(0);
		}
		if (head == null) {									// if head is null, then the list is empty so no nodes are present
			System.out.println("List is empty.");			// so can't insert since there is no index
			return false;
		}
		if(index==0) {									// if the index is 0, so if we want to add a new node at the start of the list
			head = new CellNode(cellP, head);			// head points to the new node that we created to insert
			size++;										// size is increased since we added a new node at the start of the list
			return true;
		}
		
		CellNode t = head;							// we start with pointer t pointing to head
		int i=0;
		for (i=0;i<index-1;i++) {					// use a for loop for t to point to the next node until we reach the node with index-1 as index
			if (t.next!=null) {						// if the next node is not null
			t =t.next;								// then t continues to point to next node until it reaches the index index-1
			}
		}
		if(t.next==null) {								//if the index goes out of the scope of the list
			System.out.println("index was not found");
			return false;
		}
		if(t.next!=null) {								//if the index is in the list
		CellNode n = new CellNode(cellP, t.next);		// we create a new node n with object cellP at the the position of index
		t.next =n;										// t will point to the next node(the index passed at the parameter), which is the node n we just created
		n = null;										// n will now point to null
		size++;											// size is increased since we inserted a new node in the list
		return true;
		}
		return true;
	}
	
	/**
	 * The node pointed by that index is deleted from the list if the index is valid
	 * 
	 * @param index, an integer value
	 * @return true if deleted
	 * @return false if not deleted
	 */
	public boolean deleteFromIndex(int index) {							//accepts one integer parameter representing an index.
																		
		try {															// If the index is not valid, the method must throw a NoSuchElementException
																		//and terminate the program. Otherwise; the node pointed by that index is deleted from the list.
			if(index<0 || index>size-1)
				throw new NoSuchElementException("index does not exist");
		}
		catch(NoSuchElementException e) {
			String errorMessage = e.getMessage();
			System.out.println(errorMessage);
			System.out.println("terminating the program");
			System.exit(0);
		}
		if (head == null) {								// if head is null, then the list is empty so no nodes are present
			System.out.println("List is empty.");		// so can't delete since there is no index
			return false;
		}
		CellNode t = head;								// we start with pointer t pointing to head
		if(index==0) {									// if the index is 0, so if we want to delete a node at the start of the list
			head = t.next;								// then head points to the next node in the list so the old head is in the garbage collector
			size--;										//size is decreased since we removed a node at the start of the list
			return true;
		}
		
		
		int i=0;
		for (i=0;i<index-1;i++) {					// use a for loop for t to point to the next node until we reach the node with index-1 as index
			if (t.next!=null) {						// if the next node is not null
			t =t.next;								// then t continues to point to next node until it reaches the index index-1
			}
		}
		if(t.next==null) {									//if the index goes out of the scope of the list
			System.out.println("index was not found");
			return false;
		}
		
		if(t.next!=null) {									//if the index is in the list
		t.next=t.next.next;									// t points to the node after the next node. So the node that is skipped is automatically sent to the garbage collector
		size--;												// size is decreased since we removed a node from the list
		}
		return true;
	}
	
	/**
	 * deletes the first node in the list (the one pointed by head)
	 * 
	 * @return true, if deleted
	 * @return false, if not deleted
	 */
	public boolean deleteFromStart() {				
		
		
		if (head == null) {								// if head is null, then the list is empty so no nodes are present
			System.out.println("List is empty.");		// so can't delete since there is no nodes
			return false;
		}
		
		
		
		CellNode t = head;								// we start with pointer t pointing to head
		if(head!=null) {								// if the head is not null so if the list is not empty
			head = t.next;								// then head points to the next node in the list so the old head is in the garbage collector
			size--;										//size is decreased since we removed a node at the start of the list
			return true;
		}
		
	return true;
		
	}
	
	/**
	 * the node pointed by that index is replaced from the list if the index is valid
	 * 
	 * @param cellP, a CellPhone object
	 * @param index, an integer value
	 * @return true if replaced
	 * @return false if not replaced
	 */
	public boolean replaceAtIndex(CellPhone cellP, int index) {      //accepts two parameters, an object from CellPhone class, and an integer representing an index.
		                                                             //The goal of the method is for the object in the node at the passed index to be replaced by the passed object
		try {															// If the index is not valid, the method must throw a NoSuchElementException
																		//and terminate the program. Otherwise; the node pointed by that index is replaced from the list.
			if(index<0 || index>size-1)
				throw new NoSuchElementException("index does not exist");
		}
		catch(NoSuchElementException e) {
			String errorMessage = e.getMessage();
			System.out.println(errorMessage);
			System.out.println("terminating the program");
			System.exit(0);
		}
		if (head == null) {											// if head is null, then the list is empty so no nodes are present
			System.out.println("List is empty.");					// so can't replace since there is no nodes
			return false;
		}
		CellNode t = head;											// we start with pointer t pointing to head
		if(index==0) {												// if the index is 0, so if we want to replace a node at the start of the list
			t.cell = cellP;											// the cell phone object pointed by t(in the head) is replaced by the object cellP passed as the parameter
		
			return true;
		}
		
		int i=0;
		for (i=0;i<=index-1;i++) {									// use a for loop for t to point to the next node until we reach the node with index-1 as index
			if (t.next!=null) {										// if the next node is not null
			t =t.next;												// then t continues to point to next node until it reaches the index index-1
			}
		}

		if(t==null) {									//if the index goes out of the scope of the list
			System.out.println("index was not found");
			return false;
		}
		
		if(t!=null) {										//if the index is in the list
		t.cell =cellP;										// the cell phone object pointed by t(at the index passed in the parameter) is replaced by the object cellP passed as the parameter
		return true;
		}
	
		return true;
	}
	
	/**
	 * The method then searches the list for a node with a cell phone with that serial number. If such an 
	 *object is found, then the method returns a pointer to that node where the object is found; otherwise, 
	 *the method returns null. The method must keep track of how many iterations were made before 
	 *the search finally finds the phone or concludes that it is not in the list
	 * 
	 * @param sn, a serial number
	 * @return t, a CellNode object if found
	 * @return null if not found
	 */
	public CellNode find(long sn) {	//THIS METHOD MAY RESULT IN A PRIVACY LEAK SINCE IT RETURNS A POINTER. IHE USER CAN USE SETTER METHODS TO ASSIGN ANY VALUES INCLUDING THE VALUE OF NULL WHICH CAN BRAK THE LIST NODES.
									//SOLUTION: 1. CREATING A NEW NODE WITH CLONE OF THE CELL PHONES, SO IF THE USER DESTROYS A CELL PHONE IN THE LIST, IT DESTROYS THE CLONE
											   //2. MAKE FIND METHOD PRIVATE SO USE IT AS A HELPING METHOD
											  //3.  KEEP THE cellNode CLASS PRIAVTE, THEN MAKE THE FIND METHOD PUBLIC
														//accepts one parameter of type long representing a serial number. 
														//The method then searches the list for a node with a cell phone with that serial number. If such an 
														//object is found, then the method returns a pointer to that node where the object is found; otherwise, 
														//the method returns null. The method must keep track of how many iterations were made before 
														//the search finally finds the phone or concludes that it is not in the list
		int iterationNb=0;								// the iteration starts at index 0
		CellNode t = head;								// the node t starts by pointing at head
		while(t != null)								// while the node t is not empty
		{
			iterationNb++;								// the iteration gets incremented 
			if (t.cell.getSerialNum() == sn) {			//if the serial number of the of the cell phone object pointed by t is the serial number passed in the parameter
				System.out.println("The number of itterations perfomed is " + iterationNb);

				return t; // returns the pointer t
			}
			t = t.next;		//t points to the next node until there is no more nodes left in the list
			
		}
		return null; // value was not found in the list
	}
	
	/**
	 * The method returns true if an object with the serial number passed as the parameter is in the list; otherwise, the 
	 *method returns false
	 * 
	 * @param sn, the serial number, which is a long value
	 * @return true if the list contains the serial number
	 * @return false if the list does not contain the serial number
	 */
	public boolean contains(long sn)//accepts one parameter of type long representing a serial 
									//number. The method returns true if an object with that serial number is in the list; otherwise, the 
									//method returns false
	{
		if(find(sn) != null)  //if the find method finds the serial number passed in the parameter
			return true;		
		else
			return false;
	}
	
	/**
	 * displays the contents of the list
	 * 
	 */
	public void showContents() {		

		CellNode temp = head;		//pointer temp points to the head
		if (temp == null)			// if the temp so head is null, then the list is empty
			System.out.println("\nThere is nothing to display; list is empty." );
		else {						//the list is not empty
			System.out.println("The current size of the list is " + size + ". Here are the contents of the list");
			System.out.println("===============================================================================");
			while(temp != null)			//while temp does not point to a null
			{
				System.out.println(temp.cell + " ---> ");		//it print the toStrign of the cell phone object in the node pointed by the temp
				temp = temp.next;								// temp points to the next node
			}
		System.out.println("X");
		}
	}

	
	/**
	 *  If all nodes are equal in the same order than the two list are equal and true; otherwise it is false
	 *  
	 *  
	 * @return true if the two lists contain similar objects
	 * @return false if the two lists do not contain similar objects
	 * 
	 *  
	 */
	public boolean equals(Object obj) {		//equals(), which accepts one parameter of type CellList. The method 
											//returns true if the two lists contain similar objects; otherwise the method returns false
		
			if (obj == null || this == null || this.getClass() != obj.getClass())
				return false;

			else {
		CellList other = (CellList) obj;
		if(size!=other.size)			// if both list of nodes or list of cell phones do not have the same size
			return false;				// it is false
		CellNode t1 = head;				// start the position of t1 to the head node of the calling cell phone object
		CellNode t2 = other.head;		// star the position of t2 to the head node of the passed cell phone object
		while(t1!=null)					// while the node is not empty
		{
			if(!(t1.cell.equals(t2.cell)))		//if the node pointed by t1 is not equal to the node pointed by t2
				return false;					// it is false
			t1 = t1.next;						// t1 moves to the next node
			t2 = t2.next;						// t2 moves to the next node
		}
		return true;						// if all nodes are equal in the same order than the two list are equal
				}
	}
	
	
	
	
	

	
	
}


/**
 * 
 * (a) Create at least two empty lists from the CellList class;
 * (b) Open the Cell_Info.txt file, and read its contents line by line. Use these records to 
 *     initialize one of the CellList objects you created above. You can simply use the 
 *	   addToStart() method to insert the read objects into the list. However, the list should not 
 *     have any duplicate records, so if the input file has duplicate entries, which is the case in the file 
 *     provided with the assignment for instance, your code must handle this case so that each record 
 *     is inserted in the list only once;
 * (c) Show the contents of the list you just initialized;
 * (d) Prompt the user to enter a few serial numbers and search the list that you created from the input 
 *     file for these values. Make sure to display the number of iterations performed; 
 * (e) Following that, you must create enough objects to test each of the constructors/methods of your 
	   classes. The details of this part are left as open to you. You can do whatever you wish as long as 
 *     your methods are being tested including some of the special cases. 
 * 
 * 
 * @author Asim Rahman and Gianluca Girardi
 * @version 1
 *
 */

public class CellListUtilization {

	/**
	 * the main method
	 * 
	 * @param args, An array of Strings
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("--------------------------------------------");
		System.out.println("Welcome to the Cell List Utilization program"); //Welcome message
		System.out.println("--------------------------------------------");
		
		
		CellList cellList1 = new CellList(); 		//Create an empty list called cellList1 from the CellList class;
		
		
		Scanner sc = null; 		//Defining the scanner and initializing sc here since if it is done inside the try block then it would be local to the try block
		
		try
		{
			sc = new Scanner(new FileInputStream("Cell_Info.txt"));			//scanner to read from Cell_Info.txt file	     
		}
		catch(FileNotFoundException e) 
		{							   
			System.out.println("Could not open input file for reading."
					+ " Please check if file exists.");	
			System.out.print("Program will terminate.");
			System.exit(0);			   
		}

		Long sn;
		String brand;
		double price;
		int year;
		int i=0;
		String name;
		
		while(sc.hasNextLine() )   //while the file has another line
		{
			
			sn = sc.nextLong();
			brand = sc.next();
			price = sc.nextDouble();
			year = sc.nextInt();
			if(!cellList1.contains(sn)) { // the list should not have any duplicate records, so if the input file has duplicate entries, the contains method handle this case so that each record is inserted in the list only once;
			CellPhone cell1 = new CellPhone(sn, brand,year, price);
			cellList1.addToStart(cell1);
			}

			
		}

		cellList1.showContents(); //display the contents cellList1
		CellList cellList2 = new CellList(cellList1);  //create a copy of cellList1 called cellList2 with a copy constructor
		cellList2.showContents(); //display the contents of cellLsit2

		
		 
		Scanner input = new Scanner(System.in);
		
		try {
		System.out.print("Please enter a serial Number in order to find it in the first list(enter -1 or non integer value to stop entering serial number):");
		long serial = input.nextLong();
		while(serial != -1) {
			CellList.CellNode x = cellList1.find(serial);	
			if (x == null) {  //if the serial number is not found
			System.out.println("\nNo cell phones with serial number " + serial + " was found in the list");
			}
			else { //if the serial number was found
			System.out.println("\nCell phones with serial number " + serial + " was found in the list");
			}
			
			System.out.print("Please enter a serial Number(enter -1 to stop entering serial number):");
			serial = input.nextLong();
		}
		}
		catch(InputMismatchException e) {
			input.nextLine();
			System.out.println("You did not enter an integer!");
		}
		
		
		if (cellList1.equals(cellList2)) {
			System.out.println("The two list of cell phones are equal");
		}
		else {
			System.out.println("The two list of cell phones are not equal");
		}
		
		
		
		System.out.print("Please enter an index to insert a cell phone in the first list:");
		try {
		int index = input.nextInt();
		CellPhone cell3 = new CellPhone(200000, "Google",2022, 300);
		cellList1.insertAtIndex(cell3, index);
		cellList1.showContents();
		}
		catch(InputMismatchException e) {
			input.nextLine();
			System.out.println("You did not enter an integer!");
		}
		
		System.out.print("Please enter an index to delete a cell phone in the first list:");
		try {
		int index2 = input.nextInt();
		cellList1.deleteFromIndex(index2);
		cellList1.showContents();
		}
		catch(InputMismatchException e) {
			input.nextLine();
			System.out.println("You did not enter an integer!");
		}
		
		
		
		System.out.print("Please enter an index to replace a cell phone in the first list:");
		try {
		int index3 = input.nextInt();
		CellPhone cell4 = new CellPhone(300000, "faceBook",2021, 400);
		cellList1.replaceAtIndex(cell4,index3);
		cellList1.showContents();
		}
		catch(InputMismatchException e) {
			input.nextLine();
			System.out.println("You did not enter an integer!");
		}
		
		
		
		if (cellList1.equals(cellList2)) {
			System.out.println("The two list of cell phones are equal");
		}
		else {
			System.out.println("The two list of cell phones are not equal");
		}
		
		System.out.println("Performing some action on the second list");
		
		CellPhone cell5 = new CellPhone(400000, "Apple",2019, 500);
		System.out.println("replacing index 0:");
		cellList2.replaceAtIndex(cell5,0);							//replaceAtIndex method with index 0
		cellList2.showContents();
		
		
		CellPhone cell6 = new CellPhone(500000, "Samsung",2015, 300);
		System.out.println("replacing index 5:");
		cellList2.replaceAtIndex(cell6,5);								//replaceAtIndex method with general case
		cellList2.showContents();
		
		CellPhone cell7 = new CellPhone(300000, "Huwai",2017, 800);
		System.out.println("replacing index 22:");
		cellList2.replaceAtIndex(cell7,22);								//replaceAtIndex method with last index 
		cellList2.showContents();
		
		System.out.println("deleting index 22:");
		cellList2.deleteFromIndex(22);									//deleteFromIndex method with last index
		cellList2.showContents();
		
		System.out.println("deleting index 0:");
		cellList2.deleteFromIndex(0);									//deleteFromIndex method with index 0
		cellList2.showContents();
		
		System.out.println("deleting index 5:");
		cellList2.deleteFromIndex(5);									//deleteFromIndex method with general case
		cellList2.showContents();
		
		CellPhone cell8 = new CellPhone(80000, "Sony",2018, 2000);
		System.out.println("inserting at index 19:");
		cellList2.insertAtIndex(cell8, 19);								//insertAtIndex method with last index
		cellList2.showContents();
		
		CellPhone cell9 = new CellPhone(80000, "XIO",2019, 3500);
		System.out.println("inserting at index 0:");
		cellList2.insertAtIndex(cell9, 0);								//insertAtIndex method with index 0
		cellList2.showContents();
		
		CellPhone cell10 = new CellPhone(90000, "Apple",2022, 4500);
		System.out.println("inserting at index 5:");
		cellList2.insertAtIndex(cell10, 5);								//insertAtIndex with general case
		cellList2.showContents();
		
		if (cellList1.equals(cellList2)) {
			System.out.println("The two list of cell phones are equal");
		}
		else {
			System.out.println("The two list of cell phones are not equal");
		}
		
		CellPhone cell11 = new CellPhone(64533, "Google",2022, 2505);
		System.out.println("Adding to the start of the list:");
		cellList2.addToStart(cell11);
		cellList2.showContents();
		
		cellList2.deleteFromStart();
		System.out.println("deleting to the start of the list:");
		cellList2.showContents();
		
		
		
		System.out.println("Creating a third list and performing some actions on it");
		
		CellList cellList3 = new CellList();
		CellPhone cell12 = new CellPhone(20000, "Samsung",2022, 1500);
		cellList3.addToStart(cell12);										//creating a list with one node 
		cellList3.showContents();
		
		CellPhone cell13 = new CellPhone(3000, "Apple",2019, 2500);
		System.out.println("replacing at index 0:");
		cellList3.replaceAtIndex(cell13,0);									//replaceAtIndex method when only one node is present
		cellList3.showContents();
		
		System.out.println("replacing at index 0:");
		cellList3.deleteFromIndex(0);										//deleteFromIndex method when only one node is present
		cellList3.showContents();
		
		CellPhone cell14 = new CellPhone(4000, "Sony",2012, 320);
		System.out.println("deleting to the start of the list:");
		cellList3.addToStart(cell14);
		cellList3.showContents();
		
		CellPhone cell15 = new CellPhone(5000, "Huwai",2015, 500);
		System.out.println("replacing at index 0:");
		cellList3.insertAtIndex(cell15, 0);									//insertAtIndex method when only one node is present
		cellList3.showContents();
		
		
		System.out.println("Thank you for using the cell list utilization program. Goodbye!");   //closing message

	}

}
