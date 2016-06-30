/**
 * Handler that is created in Server to get the String
 * sent by the Client and then create the Message object and
 * write it to the ObjectOutputStream.
 *
 * @author Scott Henderson
 * 201212243
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ClientHandler implements Runnable {
	/*
	 * PLEASE SEE ATTACHED DOCUMENT CONTAINING VERSION HISTORY AND TESTING
	 */
	private Socket client;
	
	public ClientHandler(Socket client){
		this.client = client;
	}
	
	@Override
	public void run(){
		try {	
			// we have a connection
			InputStream in = client.getInputStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));
			
			//get the String from the InputStream and create the Message using
			String message;
			message = bin.readLine();
			Message m = new MessageImpl(message);
			
			//send Message object back to the Client
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			out.writeObject(m);
			
			//close all streams, reader and Client
			bin.close();
			in.close();
			out.close();
			client.close();
		}
		catch(IOException ioe){
			System.err.println(ioe);
		}
	}
}
