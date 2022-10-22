import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class OnlineUsers extends Thread {

	String users = "";
	private Socket incoming;
	
	public OnlineUsers(Socket incoming)
	{
		this.incoming = incoming;
	}
	public void run() {
		
		try {
			
			PrintWriter out = null;
			
			
			int size = TCPMutliServer.getHashMap().size();
			
			while (true) {
				Thread.sleep(10000);
				
				/*TCPMutliServer.getHashMap().forEach((key, value) -> {
					

					users += " - " + value + " - ";
					//System.out.println("User: " + value);
					
	               });*/
				
				//System.out.println("is online.");
				for(Socket s1: TCPMutliServer.getHashMap().keySet()) {
					out = new PrintWriter(new OutputStreamWriter(s1.getOutputStream()));//
					out.println("-----" + TCPMutliServer.getHashMap().get(incoming) + " is online!" +"-----"); //client isimleri TCPMutliServer.getHashMap().get(incoming)
					//out.println("Onliner User(s): " + users );
					out.flush();
					break;
				}
				
				
				
				
				
				users = "";
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
	


//new OnlineUsers().start();