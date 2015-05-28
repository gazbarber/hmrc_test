package shoppingcart;

public enum ShoppingItemsEnum {

	Apple(0.60), Orange(0.25);

	private double value;
	
	ShoppingItemsEnum(double value){
		this.value = value;
	}

	public double getValue() {
		return value;
	}
	
}
