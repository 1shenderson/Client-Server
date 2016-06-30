/**
 * Message interface
 *
 * @author Scott Henderson
 * 201212243
 * 
 */

public interface Message {
	/*
	 * PLEASE SEE ATTACHED DOCUMENT CONTAINING VERSION HISTORY AND TESTING
	 */
	/**
 	 * Set the number of characters and digits in the message
	 */
	public void setCounts();

	/**
	 * Get the number of characters a .. z A .. Z
	 */
	public int getCharacterCount();

	/**
	 * Get the number of digits 0 .. 9
	 */
	public int getDigitCount();
}
