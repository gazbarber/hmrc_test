package shoppingcart;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class OfferCalculatorTest {

	OfferCalculator offerCalculator;
	
	@Before
	public void setup(){
		offerCalculator = new OfferCalculator();
	}
	
	@Test
	public void apples2for1Test() {
		List<ShoppingItemsEnum> apples = new ArrayList<ShoppingItemsEnum>();
		apples.add(ShoppingItemsEnum.Apple);
		apples.add(ShoppingItemsEnum.Apple);
		//2 apples for the price of 1 so the discount will be £0.50
		double result = offerCalculator.calculateOffersDiscountValue(apples);
		assertEquals(0.6d, result,  Double.MIN_VALUE);
	}

	
	@Test
	public void oranges3or2Test() {
		List<ShoppingItemsEnum> oranges = new ArrayList<ShoppingItemsEnum>();
		oranges.add(ShoppingItemsEnum.Orange);
		oranges.add(ShoppingItemsEnum.Orange);
		oranges.add(ShoppingItemsEnum.Orange);
		//3 oranges for the prices of 2 so the discount will be £0.25
		double result = offerCalculator.calculateOffersDiscountValue(oranges);
		assertEquals(0.25d, result,  Double.MIN_VALUE);
		
		oranges.add(ShoppingItemsEnum.Orange);
		oranges.add(ShoppingItemsEnum.Orange);
		oranges.add(ShoppingItemsEnum.Orange);
		
		result = offerCalculator.calculateOffersDiscountValue(oranges);
		assertEquals(0.5d, result,  Double.MIN_VALUE);
	}
	
	@Test
	public void appleSingleTest() {
		List<ShoppingItemsEnum> apples = new ArrayList<ShoppingItemsEnum>();
		apples.add(ShoppingItemsEnum.Apple);
		double result = offerCalculator.calculateOffersDiscountValue(apples);
		assertEquals(0d, result,  Double.MIN_VALUE);
	}
	
	@Test
	public void appleMoreThanOfferTest() {
		List<ShoppingItemsEnum> apples = new ArrayList<ShoppingItemsEnum>();
		apples.add(ShoppingItemsEnum.Apple);
		apples.add(ShoppingItemsEnum.Apple);
		apples.add(ShoppingItemsEnum.Apple);
		double result = offerCalculator.calculateOffersDiscountValue(apples);
		assertEquals(0.6d, result,  Double.MIN_VALUE);
		

		apples.add(ShoppingItemsEnum.Apple);
		apples.add(ShoppingItemsEnum.Apple);
		result = offerCalculator.calculateOffersDiscountValue(apples);
		assertEquals(1.2d, result,  Double.MIN_VALUE);
		
	}

	
	@Test
	public void orangeLessthanOfferTest() {
		List<ShoppingItemsEnum> oranges = new ArrayList<ShoppingItemsEnum>();
		oranges.add(ShoppingItemsEnum.Orange);
		double result = offerCalculator.calculateOffersDiscountValue(oranges);
		assertEquals(0d, result,  Double.MIN_VALUE);
		

		oranges.add(ShoppingItemsEnum.Orange);
		result = offerCalculator.calculateOffersDiscountValue(oranges);
		assertEquals(0d, result,  Double.MIN_VALUE);
	}
	
	@Test
	public void orangeMorethanOfferTest() {
		List<ShoppingItemsEnum> oranges = new ArrayList<ShoppingItemsEnum>();
		oranges.add(ShoppingItemsEnum.Orange);
		oranges.add(ShoppingItemsEnum.Orange);
		oranges.add(ShoppingItemsEnum.Orange);
		oranges.add(ShoppingItemsEnum.Orange);
		double result = offerCalculator.calculateOffersDiscountValue(oranges);
		assertEquals(0.25d, result,  Double.MIN_VALUE);
		
		oranges.add(ShoppingItemsEnum.Orange);
		result = offerCalculator.calculateOffersDiscountValue(oranges);
		assertEquals(0.25d, result,  Double.MIN_VALUE);
	}
}
