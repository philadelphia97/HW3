package hw3_v1_hess;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Author: Phillip D. Hess
 * class : COP2551
 * description: This program takes input for a boat rental company
 * you can input various details about a boat and the program will inform you whether it can be auctioned or not
 */

	//======MAIN CLASS===================

public class HW3_V1_Hess {
	
	static Scanner get = new Scanner(System.in);
	static String input = "";
	static int answer = 0;
	static ArrayList<Boat> auction = new ArrayList<Boat>();
	static DecimalFormat DF = new DecimalFormat("$####.00");

	//======MAIN  METHOD===================

	public static void main(String[] args) {
		
		//declarations
		String searchVIN = "";
		int foundAt = -1;
		
		
		while (answer != 4) {
			answer = menu();
			switch(answer) {
			
			case 1 : Boat boatForAuction = new Boat();
			boatForAuction.input();
			auction.add(boatForAuction);
			break ;
			
			case 2: input = JOptionPane.showInputDialog("Enter the VIN of the boat you would like to search for : ");
				
					searchVIN = input;
					foundAt = searchBoat(searchVIN);
					if (foundAt == -1) {
						JOptionPane.showMessageDialog(null, searchVIN + " was not found!");
					} else {
						auction.get(foundAt).recipt();
					} break;
			
			case 3: dispAllBoats();
			
			case 4: if (answer == 2) 
				JOptionPane.showMessageDialog(null, "Thank for for using B.A.3000");
			
		}//end while 
			
		}//end if
		
		}//end main
	//==================DISPLAY ALL EMPLOYEES==================
	/*
	 * this method displays all boats + the information for each
	 */
	
	public static void dispAllBoats()
	{
	for(int i = 0; i < auction.size(); i++) {
		JOptionPane.showMessageDialog(null,( "VIN : " + auction.get(i).VIN + "\n"
											+ "Original Price : " + auction.get(i).originalPrice + "\n"
											+ "Hours  : " + auction.get(i).hours + "\n"
											+ "Years  : " + auction.get(i).years + "\n"
											+ "Auction Price : " + auction.get(i).auctionPrice + "\n"
											+ "This boat  " + auction.get(i).toBeAuctioned));
		

	};
	}
	
	//===============SEARCH BOAT=================
	/*
	 * this method takes in a String, initiates an integer to 0, and loops while that integer is less
	 * than the size of the array list, if the VIN is found it displays the boat, if not it will tell you
	 * "NOT FOUND" 
	 */
	
	public static int searchBoat(String searchVIN) {
		int i = 0;
		while (i < auction.size()){
			if (searchVIN.equals(auction.get(i).VIN)) 
				return i;
			 else 
				i++;
			}
		return -1;
	}
	
	//=======================MENU================
	/*
	 * this method displays which numbers correspond to which menu items
	 */
	
	public static int menu() {
		input = JOptionPane.showInputDialog("1 - Add a Boat " + "\n" + 
											"2 - Search for a Boat " + "\n" + 
											"3 - Display all Boats " + "\n" + 
											"4 - Quit Program " );
		answer = Integer.parseInt(input);
		return answer;
		
		
}	//end while
	
	
	
	//===============CLASS OBJECT BOAT============
	/*
	 * this object BOAT sets up variable needed to make it's constructor
	 */
	
	static class Boat {
		//declarations
			//object
		String VIN;
		String toBeAuctioned;
		double originalPrice;
		double auctionPrice;
		int hours;
		int years;
		boolean status;
			
	//=================CONSTRUCTOR W/O ARGUMENTS===\
		/*
		 *this constructor creates a copy of the object without arguments
		 */
		
	 Boat() {
		 VIN ="";
		 toBeAuctioned = "";
		 originalPrice = 0;
		 auctionPrice = 0;
		 hours = 0;
		 years = 0;
		 status = false;
		}
	 
	//================CONSTRUCTOR W ARGUMENTS=====
	 /*
	  * this constructor takes in the arguments for the object
	  */
	 
	 Boat(String VIN, String toBeAuctioned,  double originalPrice, double auctionPrice, int hours, int years, boolean status) {
		 this.VIN ="";
		 this.toBeAuctioned= "";
		 this.originalPrice = 0;
		 this.auctionPrice = 0;
		 this.hours = 0;
		 this.years = 0;
		 this.status = false;
		}
	 
	//================INPUT METHOD================================
	 /*
	  * this method gets all the input for the BOAT object
	  */
	 
	 void input() {
		getVIN();
		getOriginalPrice();
		getEngineHours();
		getYearsInOperation();
		calcStatus();
		calcAuctionPrice();
		recipt();
	 }
		 
	 //================GET VIN================================
	 /*
	  * this method gets the VIN for the BOAT object
	  */	
	 void getVIN() {
		 input = JOptionPane.showInputDialog("Please provide the VIN of your boat");
		 VIN = input;
	 }
	 
	//====================GET ORIGINAL PRICE===================
	 /*
	  * this method gets the original price for the BOAT object
	  */
	 
	 void getOriginalPrice() {
		 input = JOptionPane.showInputDialog("Please provide the Original price of your boat");
		 originalPrice = Double.parseDouble(input);
	 }
	 
	//=====================GET ENGINE HOURS=====================
	 /*
	  * this method gets engine hours the BOAT object
	  */
	 void getEngineHours() {
		 input = JOptionPane.showInputDialog("Please provide how many hours your engine has run");
		 hours = Integer.parseInt(input);
	 }
	 
	//=====================GET YEARS IN OPERATION=============
	 /*
	  * this method gets years in operation the BOAT object
	  */
	 void getYearsInOperation() {
		 input = JOptionPane.showInputDialog("Please provide how many years your boat has been in operation");
		 years = Integer.parseInt(input);
	 }
	 
	//=====================CALCULATE STATUS=================
	 /*
	  * this method calculates whether or not the boat that has been added is eligible for auction
	  */
	 void calcStatus() {
		 if (years > 5 && hours >= 1500) {
			 status = true;
			 toBeAuctioned = "is eligable to be auctioned !";
		 } else if (years > 10) {
			 status = true;
			 toBeAuctioned = "is eligable to be auctioned !";
		 } else {
			 status = false;
			 toBeAuctioned = "is not eligbale to be auctioned :( ";
		 }
		 
	 }
	 
	//=======================CALCULATE AUCTION PRICE=========
	 /*
	  * this method calculates the auction price for the boat that has been added
	  */
	 void calcAuctionPrice() {
		 if (status == true) {
			 auctionPrice = originalPrice * 0.25;
		 }
	 }
	 
	 
	//====================RECIPT=============================
	 /*
	  * this method displays all the information for the BOAT object
	  */ 
	 void recipt() {
		 JOptionPane.showMessageDialog(null, "VIN : " + VIN + "\n"
				 							+ " originalPrice " + originalPrice + "\n"
				 						   	+ " hours of op " + hours + "\n"
				 						  	+ " years in op " + years + "\n"
				 						  	+ " original price " + DF.format(originalPrice) + "\n"
				 						  	+ " minumum starting price " + DF.format(auctionPrice) + "\n"
				 						  	+ " your boat " + toBeAuctioned);
	 }
	
}//end class boat

//===============END OBJECT BOAT=================
	
	


	

	}//end class 
