
/*
 * class ItemSale
 * 
 * A sample implementation of the ItemSale class as described in Stage 1
 * of the Assignment 3 specification for SP3 2017.
 * 
 *  You are expected to base your assignment 3 program on this class to begin
 *  with and no changes should be required until Stage 5 - Exception Handling.
 *  
 *  Written by Craig Hamilton (25/10/2017)
 */
public class ItemSale
{

   /*
    * Stage 1 Requirement A).
    * 
    * Instance variable declarations for details that need to be recorded for
    * out representation of an item sale in an online sale system
    */
   private String itemNumber;
   private String itemDescription;
   private String itemCondition;
   private String sellerID;
   private int highestBid;
   private String bidderID;
   private boolean saleEnded;
   private String messageList;

   public ItemSale(String itemNumber, String itemDescription, 
                   String itemCondition, String seller)
   {
      this.itemNumber = itemNumber;
      this.itemDescription = itemDescription;
      this.itemCondition = itemCondition;
      this.sellerID = seller;
      
      this.bidderID = "(no bids)";
      this.messageList = "";
   }

   /*
    * Stage 1 Requirement C)
    * 
    * Accessors for item number, highest bid and sale ended variables
    */
   public String getItemNumber()
   {
      return itemNumber;
   }
   
   public int getHighestBid()
   {
      return highestBid;
   }

   public boolean isSaleEnded()
   {
      return saleEnded;
   }

   /*
    * Stage 1 Requirement D)
    * 
    * public void addMessage(String message)
    * 
    * Appends a message to the message list for this ItemSale
    */
   public void addMessage(String message)
   {
      this.messageList = this.messageList + message + "\n";
   }

   /*
    * Stage 1 Requirement E)
    * 
    * public boolean recordBid(int bidPrice, String bidderID)
    * 
    * Records the bid from the specified bidder for this ItemSale if it is higher 
    * than the current highest bid.
    * 
    * Returns true if bid was recorded successfully.
    * Returns false if bid could not be recorded.
    */
   public boolean recordBid(int bidPrice, String bidderID)
   {
      if (saleEnded == true)
      {
         return false;
      }

      else if (bidPrice <= this.highestBid)
      {
         return false;
      }

      else
      {
         this.highestBid = bidPrice;
         this.bidderID = bidderID;
         return true;
      }
   }

   /*
    * Stage 1 Requirement F)
    * 
    * public int closeSale()
    * 
    * Closes this ItemSale for further bidding
    * 
    * Returns -1 if this ItemSale has already been closed.
    * Returns final sale price if this ItemSalw was closed successfully.
    */
   public int closeSale()
   {
      if (saleEnded == true)
      {
         return -1;
      }
      else
      {
         this.saleEnded = true;
         return highestBid;
      }
   }
   
   /*
    * Stage 1 Requirement G
    * 
    *  public void printDetails()
    *  
    *  Helper method which displays details for this ItemSale
    */
   public void printDetails()
   {
      System.out.printf("%-30s %s%n", "Item Number", itemNumber);
      System.out.printf("%-30s %s%n", "Item Description:", itemDescription);
      System.out.printf("%-30s %s%n", "Item Condition:", itemCondition);
      System.out.printf("%-30s %s%n", "Seller ID: ", sellerID);
      System.out.printf("%-30s %s%n", "Highest Bid:", "$" + highestBid);
      System.out.printf("%-30s %s%n", "Bidder ID:", bidderID);

      System.out.printf("%-30s %s%n", "Sale ended:", saleEnded);
      System.out.printf("Messages about this item: %n%s%n%n", 
                        (messageList.length() > 0 ? messageList : "(none)"));
   }
}
