/**
 * Client program sending string to server and
 * receiving an Object of type Message as a 
 * reply.
 *
 * @author Scott Henderson
 * 201212243
 * 
 */

import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {
	/*
	 * PLEASE SEE ATTACHED DOCUMENT CONTAINING VERSION HISTORY AND TESTING
	 */
	public static void main(String[] args) throws IOException{
		//create the socket for the Client
		Socket sock = new Socket("127.0.0.1", 6100);
		OutputStream out = null;
		
		//get the message to be sent from the user
		String messageToSend = getInput();
		//send the String created by the user to the Server
		sendString(out, sock, messageToSend);
		//use the ObjectInputStream to get the Message Object sent back from the Server
		ObjectInputStream ois = new ObjectInputStream(sock.getInputStream());
		//get the character and digit count from the String the user typed into the Client
		printCounts(sock, ois);
		//close the Client's socket
		sock.close();
		System.out.println("Closing Client Socket.");
	}

	private static String getInput(){
		String messageToSend = "";
		boolean messageEntered = false;
		//use the Console to get the String from the user
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your message.");
		//do some input error prevention and make sure the user can't enter an empty String
		while(messageEntered == false){
			messageToSend = input.nextLine();
			if(messageToSend.equals("")){
				System.out.println("You haven't entered anything, please enter your desired message.");
			}
			else{
				messageEntered = true;
			}
		}
		//close the Scanner and return the entered String
	    input.close();
		return messageToSend;
	}
	
	private static void sendString(OutputStream out, Socket sock, String messageToSend){
		try{
			//get the sock 
			out = sock.getOutputStream();
			//create PrintWriter to write the entered String to the OutputStream
			PrintWriter outStream = new PrintWriter(out);
			//write String to OutputStream
			outStream.println(messageToSend);
			//flush OutputStream to get all buffered output bytes to be written out
			outStream.flush();
		}
		catch(IOException ioe){
			System.err.println(ioe);
		}
	}

	private static void printCounts(Socket sock, ObjectInputStream ois){
		
		try {
			try{
				//get the Message object off of the ObjectInputStream
				Message m = (MessageImpl) ois.readObject();
				System.out.println("Received Message from Server.");
				//We've already called setCounts() in each Message so just
				//print the character and digit count onto the Client Console
				System.out.println("Character count of message = " + m.getCharacterCount());
				System.out.println("Digit count of message = " + m.getDigitCount());
			}
			catch(IOException ioe){
				System.err.println(ioe);
			}
			
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}

}

