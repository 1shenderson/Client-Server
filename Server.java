/**
 * Server listening to port 6100.
 * Takes String from Client and sends a Message
 * object back to the Client.
 *
 * @author Scott Henderson
 * 201212243
 * 
 */

import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class Server{
	/*
	 * PLEASE SEE ATTACHED DOCUMENT CONTAINING VERSION HISTORY AND TESTING
	 */
	public static void main(String[] args){
		
		//create the thread pool of size 10
		ExecutorService exe = Executors.newFixedThreadPool(10);
		
		try{
			//create the socket for the server
			ServerSocket sock = new ServerSocket(6100);
			System.out.println("Server has started!");
			
			// now listen for connections
			while(true){
				try{
					//accept the client socket
					Socket client = sock.accept();
					//create and execute the ClientHandler for the thread pool
					exe.execute(new ClientHandler(client));
				}
				catch(IOException ioe){
					ioe.printStackTrace();
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
