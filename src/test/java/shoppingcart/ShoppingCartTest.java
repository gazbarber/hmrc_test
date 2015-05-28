package shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {

	ShoppingCart cart;
	
	@Before
	public void setup(){
		cart = new ShoppingCart();
	}
	
	@Test
	public void appleTest() {
		String[] apples = {"Apple"};
		String result = cart.processShoppingItems(apples);
		assertEquals("[Apple] => £0.60", result);
	}
	
	@Test
	public void applesTest() {
		String[] apples = {"Apple","Apple"};
		String result = cart.processShoppingItems(apples);
		assertEquals("[Apple, Apple] => Sub Total £1.20, offer discounts £0.60 ==> Grand Total £0.60", result);
		
		String[] moreApples = {"Apple","Apple","Apple"};
		result = cart.processShoppingItems(moreApples);
		assertEquals("[Apple, Apple, Apple] => Sub Total £1.80, offer discounts £0.60 ==> Grand Total £1.20", result);
	
		String[] evenMoreApples = {"Apple","Apple","Apple","Apple"};
		result = cart.processShoppingItems(evenMoreApples);
		assertEquals("[Apple, Apple, Apple, Apple] => Sub Total £2.40, offer discounts £1.20 ==> Grand Total £1.20", result);
		
		String[] cantBelieveTheresMoreApples = {"Apple","Apple","Apple","Apple","Apple"};
		result = cart.processShoppingItems(cantBelieveTheresMoreApples);
		assertEquals("[Apple, Apple, Apple, Apple, Apple] => Sub Total £3.00, offer discounts £1.20 ==> Grand Total £1.80", result);
	}
	
	@Test
	public void orangesTest() {
		String[] oranges = {"Orange","Orange"};
		String result = cart.processShoppingItems(oranges);
		assertEquals("[Orange, Orange] => £0.50", result);
		
		String[] offerOranges = {"Orange","Orange","Orange"};
		result = cart.processShoppingItems(offerOranges);
		assertEquals("[Orange, Orange, Orange] => Sub Total £0.75, offer discounts £0.25 ==> Grand Total £0.50", result);
		

		String[] moreOranges = {"Orange","Orange","Orange","Orange"};
		result = cart.processShoppingItems(moreOranges);
		assertEquals("[Orange, Orange, Orange, Orange] => Sub Total £1.00, offer discounts £0.25 ==> Grand Total £0.75", result);
		

		String[] evenMoreOranges = {"Orange","Orange","Orange","Orange","Orange"};
		result = cart.processShoppingItems(evenMoreOranges);
		assertEquals("[Orange, Orange, Orange, Orange, Orange] => Sub Total £1.25, offer discounts £0.25 ==> Grand Total £1.00", result);
		

		String[] anotherOfferOranges = {"Orange","Orange","Orange","Orange","Orange","Orange"};
		result = cart.processShoppingItems(anotherOfferOranges);
		assertEquals("[Orange, Orange, Orange, Orange, Orange, Orange] => Sub Total £1.50, offer discounts £0.50 ==> Grand Total £1.00", result);
	}

	
	@Test
	public void applesAndOrangesTest() {
		String[] applesAndOranges = {"Orange","Apple","Orange"};
		String result = cart.processShoppingItems(applesAndOranges);
		assertEquals("[Orange, Apple, Orange] => £1.10", result);
	}
	
	@Test
	public void noitemsTest() {
		String[] noItems = {};
		String result = cart.processShoppingItems(noItems);
		assertEquals("[] => £0.00", result);
	}
	
	@Test
	public void invalidItemsTest() {
		String[] invalidITems = {"123abc"};
		String result = cart.processShoppingItems(invalidITems);
		assertEquals("[] => £0.00", result);
	}
	
	@Test
	public void bigCart(){
		//3 for 2 on oranges, 4 oranges in cart, pay for 3 oranges
		//BOGOF on apples, 3 apples in cart, pay for 2 apples 
		//3 * 0.25 + 2 * 0.60 = £1.95
		String[] applesAndOranges = {"Orange","Apple","Orange","Apple","Apple","Orange","Orange" };
		String result = cart.processShoppingItems(applesAndOranges);
		assertEquals("[Orange, Apple, Orange, Apple, Apple, Orange, Orange] => Sub Total £2.80, offer discounts £0.85 ==> Grand Total £1.95", result);
	}
}
