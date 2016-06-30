/**
 * Message Object.
 * 
 * @author Scott Henderson
 * 201212243
 * 
 */

import java.io.*;

public class MessageImpl implements Message, Serializable{
	/*
	 * PLEASE SEE ATTACHED DOCUMENT CONTAINING VERSION HISTORY AND TESTING
	 */
	private String message;
	private int charCount = 0;
	private int digitCount = 0;
	
	public MessageImpl(String message){
		this.message = message;
		//call setCounts() in constructor so we don't need to do so in the Client
		setCounts();
	}
	
	@Override
	public void setCounts(){
		//loop for counting how many digits and characters there are in the String
		for (int i = 0; i < message.length(); i++) {
		    if (Character.isDigit(message.charAt(i))) {
		        digitCount++;
		    }
		    else{
		    	charCount++;
		    }
		}
	}
	
	@Override
	public int getCharacterCount(){
		return charCount;
	}

	@Override
	public int getDigitCount() {
		return digitCount;
	}
}
