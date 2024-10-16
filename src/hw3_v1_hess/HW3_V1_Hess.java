package hw3_v1_hess;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/*
 * Author: Phillip Hess
 * class : cop1000
 * description: when bat number reaches certain number of hours auction off boat
 * 
 */

public class HW3_V1_Hess {
	
	static Scanner get = new Scanner(System.in);
	static String input = "";
	static int answer = 0;
	static ArrayList<Boat> auction = new ArrayList<Boat>();
	static DecimalFormat DF = new DecimalFormat("$####.00");

	public static void main(String[] args) {
		input = JOptionPane.showInputDialog("Helloiw welcome to Boast Auctioneer 3000 \n "
											+ "would you like to enter a boat/n 1 for yes 2 for no");
		answer = Integer.parseInt(input);
		
		while(answer != 1 && answer != 2) {
			input = JOptionPane.showInputDialog("please eneter 1 or 2");
			answer = Integer.parseInt(input);
		}//end while
		
		while (answer == 1) {
			Boat boatForAuction = new Boat();
			boatForAuction.getVIN();
			boatForAuction.getOriginalPrice();
			boatForAuction.getEngineHours();
			boatForAuction.getYearsInOperation();
			boatForAuction.calcStatus();
			boatForAuction.calcAuctionPrice();
			boatForAuction.recipt();

			auction.add(boatForAuction);
			input = JOptionPane.showInputDialog("would you like to enter another component 1 for yes 2 for no");
			answer = Integer.parseInt(input);
			
			while(answer != 1 && answer != 2){
				input = JOptionPane.showInputDialog("please eneter 1 or 2");
				answer = Integer.parseInt(input);
		}//end while 
			if (answer == 2) 
			JOptionPane.showMessageDialog(null, "Thank for for using B.A.3000");
		}//end if
		
		}//end main
	
	//===============CLASS OBJECT BOAT=====================//
	
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
			
		//constructor w/o arguments
		 Boat() {
			 VIN ="";
			 toBeAuctioned = "";
			 originalPrice = 0;
			 auctionPrice = 0;
			 hours = 0;
			 years = 0;
			 status = false;
			}
		 
		//constructor w arguments
		 Boat(String VIN, String toBeAuctioned,  double originalPrice, double auctionPrice, int hours, int years, boolean status) {
			 this.VIN ="";
			 this.toBeAuctioned= "";
			 this.originalPrice = 0;
			 this.auctionPrice = 0;
			 this.hours = 0;
			 this.years = 0;
			 this.status = false;
			}
			
		 void getVIN() {
			 input = JOptionPane.showInputDialog("Please provide the VIN of your boat");
			 VIN = input;
		 }
		 
		 void getOriginalPrice() {
			 input = JOptionPane.showInputDialog("Please provide the Original price of your boat");
			 originalPrice = Double.parseDouble(input);
		 }
		 
		 void getEngineHours() {
			 input = JOptionPane.showInputDialog("Please provide how many hours your engine has run");
			 hours = Integer.parseInt(input);
		 }
		 
		 void getYearsInOperation() {
			 input = JOptionPane.showInputDialog("Please provide how many years your boat has been in operation");
			 years = Integer.parseInt(input);
		 }
		 
		 void calcStatus() {
			 if (years > 5 && hours >= 1500) {
				 status = true;
				 toBeAuctioned = "is eligable to be auctioned !";
			 } else if (years > 10) {
				 status = true;
				 toBeAuctioned = "is  eligable to be auctioned !";
			 } else {
				 status = false;
				 toBeAuctioned = "is not eligbale to be auctioned :( ";
			 }
			 
		 }
		 
		 void calcAuctionPrice() {
			 if (status == true) {
				 auctionPrice = originalPrice * 0.25;
			 }
		 }
			 
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
