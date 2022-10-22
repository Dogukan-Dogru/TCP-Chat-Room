import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;


public class TCPMutliServer  {
	
	private static HashMap<Socket, String> hashMap = new HashMap<Socket, String>();
	public static void main(String[] args) {
		
		
		
		try {
			boolean check = true;
			System.out.println("Server is working...");
			ServerSocket serverSocket = new ServerSocket(6789);
			while (true) {
				Socket incoming = serverSocket.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
				
				getHashMap().put(incoming, in.readLine());
				
				new ServerHelper(incoming).start();
				
				if(check == true)
				{
					new OnlineUsers(incoming).start();
					check = false;
				}
					
				
				
				
				
				
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static synchronized HashMap<Socket, String> getHashMap() {
		return hashMap;
	}

	public static synchronized void setHashMap(HashMap<Socket, String> hashMap) {
		TCPMutliServer.hashMap = hashMap;
	}
	
}