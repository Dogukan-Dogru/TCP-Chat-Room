import java.io.*;
import java.lang.*;
import java.net.*;

public class ServerHelper extends Thread {

	private Socket incoming;
	

	public ServerHelper(Socket incoming) {
		this.incoming = incoming;
	}

	public void run() {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
			PrintWriter out;
			PrintWriter out2;
			//Socket s = null;
			while (true) {
				
				String str = in.readLine();
				System.out.println("Server received : " + str); // servera basýlan
				
				
			    
				String pmstr = "";
				
				
				String[] msg = str.split(" ");
				int lenght = msg.length;
				
				if (str == null) 
				{
					break;
				} 
				else 
				{
					if(msg[0].equals("PM"))
					{
						 
						for(Socket s1: TCPMutliServer.getHashMap().keySet()) {
				
							if(msg[1].equals(TCPMutliServer.getHashMap().get(s1)))  
							{
								
								out = new PrintWriter(new OutputStreamWriter(s1.getOutputStream()));
								
								
								for(int y = 2; y <= lenght-1 ;y++)
								{
									//System.out.println(y);
									//out.println(msg[y]); //client isimleri
									pmstr += msg[y] + " ";
									//out.println(pmstr);
								}
								out.println("-PM- " +TCPMutliServer.getHashMap().get(incoming) + ": "+ pmstr); //client isimleri 
								
								out.flush();
								
							}
						      
						  
						}
					}
					else
					{
						for(Socket s1: TCPMutliServer.getHashMap().keySet()) {
							if(s1.getPort() != incoming.getPort()) {
								
								out = new PrintWriter(new OutputStreamWriter(s1.getOutputStream()));//
								out.println(TCPMutliServer.getHashMap().get(incoming) + ": " + str); //client isimleri TCPMutliServer.getHashMap().get(incoming)
								out.flush();
								
							}
						}
					}
					//out.println("Online User(s):");
					
					
				}
				
				
			}
			
			incoming.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}