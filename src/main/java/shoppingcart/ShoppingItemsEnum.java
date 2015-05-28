package shoppingcart;

public enum ShoppingItemsEnum {

	Apple(0.60), Orange(0.25);

	double value;
	
	ShoppingItemsEnum(double value){
		this.value = value;
	}
}
