/*
 * Name: Jake Duran Zerafa
 * Student ID: s3679109
 * 
 */
import java.util.*;

public class OnlineSaleSystem
{
   // shared array used to store ItemSale and BuyItNowSale objects
   private static ItemSale[] sales = new ItemSale[100];
   
   // shared count for number of sale objects currently stored in array
   private static int saleCount = 0;
   
   // shared Scanner that can be accessed from all helper methods in this class
   private static Scanner sc = new Scanner(System.in);

   /* createSampleData()
    * 
    * Helper method which will give you work with when testing the program - you
    * don't need to do anything here.
    */
   
   private static void createSampleData()
   {
      sales[saleCount] = new ItemSale("ITM009", "Extra Large Wooden Dog Kennel",
                                      "New", "AmazingPetSupplies");
      saleCount++;
      
      sales[saleCount] = new ItemSale("ITM005", "Trojan 100L Wheelbarrow",
                                      "Used", "tradie_213");
      saleCount++;

      sales[saleCount] = new ItemSale("ITM102", "Xbox One S 1TB w/ 5 games",
                                      "Used", "gamerkid_97");
      saleCount++;
      
      /*
       * The code below will not run until you have completed Stage 3 Requirement B.
       */
      
      /* (remove this line when you are ready to test BuyItNowSale functionality)
     
       
      sales[saleCount] = new BuyItNowSale("BUY013",
                                          "iPhone 7 Plus 128GB Silver 1YR Warranty",
                                          "Manufacturer Refurbished",
                                          "apple_pro_store", 825);
      saleCount++; 
      
      sales[saleCount] = new BuyItNowSale("BUY013", "iPad Pro 10.5\" 256GB Wi-Fi",
                                          "New", "cheap_phone_store", 1100);
      saleCount++;
      
      (remove this line when you are ready to test BuyItNowSale functionality) */

   }

   /*
    * main() method
    * 
    * Contains an implementation of the program menu.
    * 
    *  NOTE:
    *  
    *  You will not need to change anything here unless you implement the bonus 
    *  marks stage file handling functionality. 
    */
   public static void main(String[] args)
   {

      createSampleData();

      String input;
      
      do
      {
         printMenu();

         input = sc.nextLine();

         if (input.length() != 1)
         {
            System.out.println("Error - selection must be a single character!");
         }
         else
         {
            input = input.toUpperCase();
            System.out.println();

            switch (input)
            {
               case "A":
                  addNewItemSale();
                  break;

               case "B":
                  displaySales();
                  break;

               case "C":
                  postMessage();
                  break;

               case "D":
                  recordBid();
                  break;

               case "E":
                  closeSale();
                  break;
                  
               case "F":
                  addNewBuyItNowSale();
                  break;

               case "G":
                  updateAcceptNearestOfferStatus();
                  break;

               case "X":
                  System.out.println("Exiting Program ... Goodbye!");
                  break;

               default:
                  System.out.println("Error, invalid option selected!");
                  System.out.println("Please try Again...");

            }
         }

      } while (!input.equals("X"));
   }

   // helper method to display menu options to the screen
   public static void printMenu()
   {
      System.out
               .printf("\n********** Online Sale System Menu ********** %n%n");
      System.out.printf("A. Add New Item Sale %n");
      System.out.printf("B. Display Sales %n");
      System.out.printf("C. Post Message For Item %n");
      System.out.printf("D. Record Bid %n");
      System.out.printf("E. Close Sale %n");
      System.out.printf("F. Add New Buy It Now Sale %n");
      System.out.printf("G. Update Accept Nearest Offer Status %n");
      System.out.printf("X. Exit Program %n%n");
      System.out.printf("Enter your selection: ");
   }


   // implementation of add new item sale feature
   private static void addNewItemSale()
   {
      System.out.println("Add New Item Sale Feature");
      System.out.println();
      
      System.out.print("Enter Item Number: ");
      String itemNumber = sc.nextLine();
      System.out.print("Enter Item Description: ");
      String itemDescription = sc.nextLine();
      System.out.print("Enter Item Condition: ");
      String itemCondition = sc.nextLine();
      System.out.print("Enter Seller ID: ");
      String sellerID = sc.nextLine();
      
      sales[saleCount] = new ItemSale(itemNumber, itemDescription,
      		itemCondition, sellerID);
      saleCount++;
        
      System.out.println("\n" + itemDescription + " Added Successfully");	
   }

   // implementation of the display sales feature
   private static void displaySales()
   {
      System.out.println("Display Sales Feature");
      System.out.println();
      
      for (int i = 0; i < saleCount ; i++)
      {
      		sales[i].printDetails();	
      }

   }

   // implementation of post message feature
   private static void postMessage()
   {
      System.out.println("Post Message Feature");
      System.out.println();
      
      System.out.print("Enter Item Number: ");
      String itemNumber = sc.nextLine();
      
      ItemSale temp = null;
      
      for (int i = 0; i < saleCount; i++)
      {
      		if (sales[i].getItemNumber().equals(itemNumber))
      		{
      			temp = sales[i];
      		}
      }
      if (temp == null)
		{
			System.out.println("\nError - item number " + itemNumber + " not found!");
		}
      else
      {
      		System.out.print("Enter Message: ");
      		String message = sc.nextLine();
      		
      		temp.addMessage(message);
      		
      		System.out.println("\nMessage posted successfully for item " + itemNumber);
      }
   }

   // implementation of record bid feature
   private static void recordBid()
   {
      System.out.println("Record Bid Feature");
      System.out.println();
      
      System.out.print("Enter Item Number: ");
      String itemNumber = sc.nextLine();
      
      ItemSale temp = null;
      
      for (int i = 0; i < saleCount; i++)
      {
      		if (sales[i].getItemNumber().equals(itemNumber))
      		{
      			temp = sales[i];
      		}
      }
      if (temp == null)
		{
			System.out.println("\nError - item number " + itemNumber + " not found!");
		}
      else
      {
      		System.out.println("Current Bid: $" + temp.getHighestBid());
      		System.out.print("Enter Bid: ");
      		int bidPrice = sc.nextInt();
      		sc.nextLine();
      		System.out.print("Enter Bidder ID: ");
      		String bidderID = sc.nextLine();
      		
      		if (temp.recordBid(bidPrice, bidderID) == false)
      		{
      			System.out.println("\nError! Bid could not be recorded for item number " + itemNumber);
      		}
      		else
      		{		
      			System.out.println("\nBid recorded successfully for item number " + itemNumber);
      		}
      }
   }

   // implementation of close sale feature
   private static void closeSale()
   {
      System.out.println("Close Sale Feature");
      System.out.println();
      
      System.out.print("Enter Item Number: ");
      String itemNumber = sc.nextLine();
      
      ItemSale temp = null;
      
      for (int i = 0; i < saleCount; i++)
      {
      		if (sales[i].getItemNumber().equals(itemNumber))
      		{
      			temp = sales[i];
      		}
      }
      if (temp == null)
		{
			System.out.println("\nError - item number " + itemNumber + " not found!");
		}
      else
      {	
      		if (temp.closeSale() > 0)
      		{
      			System.out.println("\nSale closed - final sale price: $" + temp.getHighestBid() +
      					" item number " + itemNumber);
      		}
      		else if (temp.closeSale() == 0)
      		{
      			System.out.println("\nError - Cannot close sale for item number " + itemNumber);
      		}
      		else
      		{		
      			System.out.println("\nError - Sale was already closed for item number " + itemNumber);
      		}
      }
   }
   
   // implementation of add new buy it now sale feature
   private static void addNewBuyItNowSale()
   {
      System.out.println("Add New Buy It Now Sale Feature");
      System.out.println();
      
      System.out.print("Enter New Item Number: ");
      String itemNumber = sc.nextLine();
      System.out.print("Enter Description For Item: ");
      String itemDescription = sc.nextLine();
      System.out.print("Enter Condition For Item: ");
      String itemCondition = sc.nextLine();
      System.out.print("Enter Seller Name: ");
      String sellerID = sc.nextLine();
      System.out.print("Enter Buy It Now Price: ");
      int buyNowPrice = sc.nextInt();
      sc.nextLine();
      
      sales[saleCount] = new BuyItNowSale(itemNumber, itemDescription,
      		itemCondition, sellerID, buyNowPrice);
      saleCount++;
        
      System.out.println("\nNew sale added for item " + itemDescription);	
      System.out.println();
   }
   
   // implementation of update accept nearest offer status feature
   public static void updateAcceptNearestOfferStatus()
   {
      System.out.println("Update Accept Nearest Offer Status Feature");
      System.out.println();
      
      System.out.print("Enter Item Number: ");
      String itemNumber = sc.nextLine();
      
      ItemSale temp = null;
      
      for (int i = 0; i < saleCount; i++)
      {
      		if (sales[i].getItemNumber().equals(itemNumber))
      		{
      			temp = sales[i];
      		}
      }
      if (temp == null)
		{
			System.out.println("\nError - item number " + itemNumber + " not found!");
		}
      else
      {	
      		if (temp instanceof BuyItNowSale)
      		{
      			boolean returnedResult = ((BuyItNowSale)temp).acceptNearestOffer();
      			
      			if ( returnedResult == true)
      			{
      				System.out.print("Sale for item " + itemNumber + 
      						" is now accepting nearest offer!");
      				System.out.println();
      			}
      			else
      			{
      				System.out.print("Accept nearest offer status is already activated for item " 
      						+ itemNumber);
      				System.out.println();
      			}
      		}
      		else
      		{
      			System.out.println(itemNumber + " Cannot be set to accept nearest offer!");
      		}
      }
   }

}
