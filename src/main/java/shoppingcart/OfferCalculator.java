package shoppingcart;

import java.util.Collections;
import java.util.List;

public class OfferCalculator {

	//returns the discount in amount, to be take off the total
	public double calculateOffersDiscountValue(final List<ShoppingItemsEnum> shoppingCartItems){
		double offerTotal = 0;

		//buy one, get one free on Apples
		if(shoppingCartItems.contains(ShoppingItemsEnum.Apple)){
			int frequency = Collections.frequency(shoppingCartItems, ShoppingItemsEnum.Apple);
			offerTotal += Math.floor(frequency/2) * ShoppingItemsEnum.Apple.getValue();
			
		}
		//3 for the price of 2 on Oranges
		if(shoppingCartItems.contains(ShoppingItemsEnum.Orange)){
			int frequency = Collections.frequency(shoppingCartItems, ShoppingItemsEnum.Orange);
			
			//calculate the number of oranges the offer affect (not the actual end value of 3 for 2) 
			//3 for 2, therefore the saving for ever 3 oranges is the 1
			int numberOfOrangesForFree = (int)(Math.floor(frequency/3));
			offerTotal += numberOfOrangesForFree * ShoppingItemsEnum.Orange.getValue();
		}
		return offerTotal;
	}
	
	
	
}
