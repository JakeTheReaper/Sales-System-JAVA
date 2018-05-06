/*
 * Name: Jake Duran Zerafa
 * Student ID: s3679109
 * 
 */
public class BuyItNowSale extends ItemSale 
{
	//Declaring Subclass instance variables
	private int buyNowPrice;
	private boolean acceptingNearestOffer;
	
	//Subclass constructor
	public BuyItNowSale(String itemNumber, String itemDescription, 
         String itemCondition, String seller, int buyNowPrice)
	{
		super(itemNumber, itemDescription, itemCondition, seller);
		
		this.buyNowPrice = buyNowPrice;
		this.acceptingNearestOffer = false;
	}
	
	//Implementing overridden bid recording helper method
	public boolean recordBid(int bidPrice, String sellerID)
	{
		if (bidPrice > this.buyNowPrice)
		{
			bidPrice = this.buyNowPrice;
		}
		
		boolean returnedResult = super.recordBid(bidPrice, sellerID);
		if (returnedResult == false)
		{
			return false;
		}
		else
		{
			if (bidPrice == this.buyNowPrice)
			{
				super.closeSale();
			}
			return true;
		}
	}
	
	//Implement overridden sale closing method
	public int closeSale()
	{
		if (isSaleEnded() == true)
		{
			return -1;
		}
		else if (getHighestBid() < this.buyNowPrice && this.acceptingNearestOffer != true)
		{
			return 0;
		}
		else
		{
			int result = super.closeSale();
			return result;
		}
	}
	
	//Implement new method to accept nearest offer
	public boolean acceptNearestOffer()
	{
		if (this.acceptingNearestOffer == false)
		{
			this.acceptingNearestOffer = true;
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	//Implement overridden print details method
	public void printDetails()
	{
		super.printDetails();
		
		System.out.printf("%-30s %s%n", "Buy Now Price", "$" + buyNowPrice);
		System.out.printf("%-30s %s%n", "Accepting Nearest Offer", acceptingNearestOffer);
	}
}
