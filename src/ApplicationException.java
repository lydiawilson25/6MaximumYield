/**
 * A custom Exception class for the Maximum yield API
 *
 * @author Lydia
 */

public class ApplicationException extends Exception{

	private static final long serialVersionUID = 2393648618785291786L;

	/**
	 * Parameterized constructor to print the custom error message.
	 *
	 * @param message - Custom error message
	 */
	public ApplicationException(String message) {
		System.out.println(message);
	}
}
