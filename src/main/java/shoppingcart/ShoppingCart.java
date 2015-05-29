package shoppingcart;

import java.util.List;

public class ShoppingCart {

	OfferCalculator offerCalculator;
	
	public ShoppingCart(){
		offerCalculator = new OfferCalculator();
	}
	
	public String processShoppingItems(List<ShoppingItemsEnum> shoppingCartItems){		
		if(null == shoppingCartItems){
			return "£0.00"; //maybe log this as it is an invalid request 
		}
		double calculatedSubTotal = calculateSubTotal(shoppingCartItems);
		double calculatedOffersDiscountValue = offerCalculator.calculateOffersDiscountValue(shoppingCartItems);
		double total = calculatedSubTotal - calculatedOffersDiscountValue;
		return  "£"+String.format( "%.2f",total);
	}
	
	
	private double calculateSubTotal(final List<ShoppingItemsEnum> shoppingCartItems){
		double subTotal = 0;
		for(ShoppingItemsEnum item: shoppingCartItems){
			
			subTotal += item.getValue();
		}
		return subTotal;
	}
	
	
}
