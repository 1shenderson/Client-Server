import static org.junit.Assert.*;

import org.junit.Test;


public class TestMessage {
	/*
	 * PLEASE SEE ATTACHED DOCUMENT CONTAINING VERSION HISTORY AND TESTING
	 */
	//create three different message objects to test setCounts()
	Message m1 = new MessageImpl("test 123");
	Message m2 = new MessageImpl("123456789");
	Message m3 = new MessageImpl("abcdefgh");
	
	@Test
	public void testCounts(){
		
		//check each count is correct for each message
		assertEquals(m1.getCharacterCount(), 5);
		assertEquals(m1.getDigitCount(), 3);
		
		assertEquals(m2.getCharacterCount(), 0);
		assertEquals(m2.getDigitCount(), 9);
		
		assertEquals(m3.getCharacterCount(), 8);
		assertEquals(m3.getDigitCount(), 0);
	}
}
