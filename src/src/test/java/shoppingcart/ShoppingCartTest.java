package shoppingcart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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
		assertEquals(result,"[Apple, Apple] => £1.20");
	}
	
	@Test
	public void orangesTest() {
		String[] oranges = {"Orange","Orange"};
		String result = cart.processShoppingItems(oranges);
		assertEquals(result,"[Orange, Orange] => £0.50");
	}

	
	@Test
	public void applesAndOrangesTest() {
		String[] applesAndOranges = {"Orange","Apple","Orange"};
		String result = cart.processShoppingItems(applesAndOranges);
		assertEquals(result,"[Orange, Apple, Orange] => £1.10");
	}
	
	@Test
	public void noitemsTest() {
		String[] noItems = {};
		String result = cart.processShoppingItems(noItems);
		assertEquals(result,"[] => £0.00");
	}
	
	@Test
	public void invalidItemsTest() {
		String[] invalidITems = {"123abc"};
		String result = cart.processShoppingItems(invalidITems);
		assertEquals(result,"[] => £0.00");
	}
}
