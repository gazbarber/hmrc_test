package shoppingcart;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShoppingCart {

	Set<String> validCartItems;
	
	public ShoppingCart(){
		validCartItems = new HashSet<String>();
		for(ShoppingItemsEnum item: ShoppingItemsEnum.values()){
			validCartItems.add(item.name());
		}
	}
	
	public String processShoppingItems(String shoppingItems[]){
		
		//convert the shopping items into a collection of known shopping items 
		List<ShoppingItemsEnum> shoppingCartItems = getShoppingCartItems(shoppingItems);
		return outputCartValue(shoppingCartItems);
	}
	
	public List<ShoppingItemsEnum> getShoppingCartItems(final String shoppingItems[]){
		List<ShoppingItemsEnum> shoppingCartItems = new ArrayList<ShoppingItemsEnum>();
		for(String item: shoppingItems){
			if(validCartItems.contains(item)){
				shoppingCartItems.add(ShoppingItemsEnum.valueOf(item));
			}
			else{
				//log the items that are unknown, and/or add to another list for outputting on 'receipt'
			}
		}
		return shoppingCartItems;
	}
	
	public String outputCartValue(final List<ShoppingItemsEnum> shoppingCartItems){
		String result = ("[");
		
		for(int i = 0; i<shoppingCartItems.size();i++){
			result+=(shoppingCartItems.get(i).name());
			if(i!=shoppingCartItems.size()-1){
					result+=(", ");
			}
		}
		
		return result += ("] => £"
				+String.format( "%.2f",calculateTotal(shoppingCartItems)));
	}
	
	public double calculateTotal(final List<ShoppingItemsEnum> shoppingCartItems){
		return 0;
	}
	
}
