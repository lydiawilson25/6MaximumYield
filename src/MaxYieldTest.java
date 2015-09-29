import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * A Class to test the maximum yield from a given strip 
 *
 * @author Lydia
 */

public class MaxYieldTest {
	
	public static MaximumYield obj = null;
	
	/**
	 * Method instantiates the object of MaximumYield class.
	 *
	 */
	
	@Before
	public void setup(){
		obj = new MaximumYield();
	}
	
	/**
	 * Method tests if the given strip is empty and no yield is returned.
	 *
	 */	
	@Test
	public void testEmptyInput() throws ApplicationException {
		
		String str = "";
		assertEquals(0, obj.findMaximumYield(str));
	}
	
	/**
	 * Method tests if the given strip has insufficient input and application
	 * exception is thrown.
	 *
	 */	
	@Test(expected = ApplicationException.class)
	public void testInsufficientInput() throws ApplicationException {

		String str = " 147, 206, 52,, 300";
		obj.findMaximumYield(str);
	}
	
	/**
	 * Method tests if the given strip has invalid input and application
	 * exception is thrown.
	 *
	 */	
	@Test(expected = ApplicationException.class)
	public void testInvalidtInput() throws ApplicationException {

		String str = " 147, 206, 52,##, 300";
		obj.findMaximumYield(str);
	}
	
	/**
	 * Method tests if the given strip has any spaces input and maximum yield
	 * is calculated.
	 *
	 */	
	@Test
	public void testInputWithSpaces() throws ApplicationException {

		String str = " 147, 206, 52,    240, 300";
		assertEquals(506, obj.findMaximumYield(str));
	}
	
	/**
	 * Method tests if the given clean strip returns the correct maximum yield.
	 *
	 */	
	@Test
	public void testMaximumYield() throws ApplicationException {

		String str = "206, 140, 300, 52, 107";
		assertEquals(613, obj.findMaximumYield(str));
	}
	
}
