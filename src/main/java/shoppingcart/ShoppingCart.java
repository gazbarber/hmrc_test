package shoppingcart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShoppingCart {

	Set<String> validCartItems;
	OfferCalculator offerCalculator;
	
	public ShoppingCart(){
		offerCalculator = new OfferCalculator();
		validCartItems = new HashSet<String>();
		for(ShoppingItemsEnum item: ShoppingItemsEnum.values()){
			validCartItems.add(item.name());
		}
	}
	
	public String processShoppingItems(String orderItems[]){
		
		//convert the shopping items into a collection of known shopping items 
		List<ShoppingItemsEnum> shoppingCartItems = getShoppingCartItems(orderItems);
		double total = calculateSubTotal(shoppingCartItems)-offerCalculator.calculateOffersDiscountValue(shoppingCartItems);
		return outputCartReceipt(shoppingCartItems, total);
	}
	
	public List<ShoppingItemsEnum> getShoppingCartItems(final String orderItems[]){
		List<ShoppingItemsEnum> shoppingCartItems = new ArrayList<ShoppingItemsEnum>();
		for(String item: orderItems){
			if(validCartItems.contains(item)){
				shoppingCartItems.add(ShoppingItemsEnum.valueOf(item));
			}
			else{
				//log the items that are unknown, and/or add to another list for outputting on 'receipt'
			}
		}
		return shoppingCartItems;
	}
	
	public double calculateSubTotal(final List<ShoppingItemsEnum> shoppingCartItems){
		double subTotal = 0;
		for(ShoppingItemsEnum item: ShoppingItemsEnum.values()){
			int frequency = Collections.frequency(shoppingCartItems, item);
			subTotal += frequency*item.getValue();
		}
		return subTotal;
	}
	
	public String outputCartReceipt(final List<ShoppingItemsEnum> shoppingCartItems, double total){
		String result = ("[");
		
		for(int i = 0; i<shoppingCartItems.size();i++){
			result+=(shoppingCartItems.get(i).name());
			if(i!=shoppingCartItems.size()-1){
					result+=(", ");
			}
		}
		
		return result += ("] => £"
				+String.format( "%.2f",total));
	}
}
