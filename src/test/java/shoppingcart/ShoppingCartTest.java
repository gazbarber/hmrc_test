package shoppingcart;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {

	private ShoppingCart cart;	
	
	@Before
	public void setup(){
		cart = new ShoppingCart();
	}
	
	@Test
	public void appleTest() {
		List<ShoppingItemsEnum> apples = new ArrayList<ShoppingItemsEnum>();
		apples.add(ShoppingItemsEnum.Apple);
		String result = cart.processShoppingItems(apples);
		assertEquals("£0.60", result);
	}
	
	@Test
	public void applesTest() {
		List<ShoppingItemsEnum> apples = new ArrayList<ShoppingItemsEnum>();
		apples.add(ShoppingItemsEnum.Apple);
		apples.add(ShoppingItemsEnum.Apple);
		String result = cart.processShoppingItems(apples);
		assertEquals("£0.60", result);
		
		apples.add(ShoppingItemsEnum.Apple);
		result = cart.processShoppingItems(apples);
		assertEquals("£1.20", result);
	
		apples.add(ShoppingItemsEnum.Apple);
		result = cart.processShoppingItems(apples);
		assertEquals("£1.20", result);
		
		apples.add(ShoppingItemsEnum.Apple);
		result = cart.processShoppingItems(apples);
		assertEquals("£1.80", result);
	}
	
	@Test
	public void orangesTest() {
		List<ShoppingItemsEnum> oranges = new ArrayList<ShoppingItemsEnum>();
		oranges.add(ShoppingItemsEnum.Orange);
		oranges.add(ShoppingItemsEnum.Orange);
		String result = cart.processShoppingItems(oranges);
		assertEquals("£0.50", result);
		
		oranges.add(ShoppingItemsEnum.Orange);
		result = cart.processShoppingItems(oranges);
		assertEquals("£0.50", result);
		

		oranges.add(ShoppingItemsEnum.Orange);
		result = cart.processShoppingItems(oranges);
		assertEquals("£0.75", result);
		

		oranges.add(ShoppingItemsEnum.Orange);
		result = cart.processShoppingItems(oranges);
		assertEquals("£1.00", result);
		

		oranges.add(ShoppingItemsEnum.Orange);
		result = cart.processShoppingItems(oranges);
		assertEquals("£1.00", result);
	}

	
	@Test
	public void applesAndOrangesTest() {
		List<ShoppingItemsEnum> applesAndOranges = new ArrayList<ShoppingItemsEnum>();
		applesAndOranges.add(ShoppingItemsEnum.Orange);
		applesAndOranges.add(ShoppingItemsEnum.Apple);
		applesAndOranges.add(ShoppingItemsEnum.Orange);

		String result = cart.processShoppingItems(applesAndOranges);
		assertEquals("£1.10", result);
	}
	
	@Test
	public void noitemsTest() {
		String result = cart.processShoppingItems(null);
		assertEquals("£0.00", result);
	}
	

	
	@Test
	public void bigCart(){
		//3 for 2 on oranges, 4 oranges in cart, pay for 3 oranges
		//BOGOF on apples, 3 apples in cart, pay for 2 apples 
		//3 * 0.25 + 2 * 0.60 = £1.95
		List<ShoppingItemsEnum> bigCart = new ArrayList<ShoppingItemsEnum>();
		bigCart.add(ShoppingItemsEnum.Orange);
		bigCart.add(ShoppingItemsEnum.Apple);
		bigCart.add(ShoppingItemsEnum.Orange);
		bigCart.add(ShoppingItemsEnum.Apple);
		bigCart.add(ShoppingItemsEnum.Apple);
		bigCart.add(ShoppingItemsEnum.Orange);
		bigCart.add(ShoppingItemsEnum.Orange);
		
		String result = cart.processShoppingItems(bigCart);
		assertEquals("£1.95", result);
	}
}
