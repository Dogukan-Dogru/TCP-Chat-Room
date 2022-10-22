import java.io.*;
import java.net.*;
import java.util.Scanner;


public class TCPClient  {

	public static long first = 0;
	public static long last = 10;
	public static long check;
	
	public static void main(String[] args) {
		try {
			
			System.out.println("Client is working");
			String host = "localhost";
			
			Socket socket = new Socket(host, 6789);
			
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			PrintWriter nick = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			new ClientPrinter(in).start();
			String str;
			String Nickname;
			System.out.println("Enter Your Nickname: ");
		    Nickname = inFromUser.readLine();
			nick.println(Nickname);
			nick.flush();
			
			
			
			while (true) {
				

				str = inFromUser.readLine();
				out.println(str);
				out.flush();
				
				
			}
			
			
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	
	 // Getter
	  public static Long getCheck() {
	    return check;
	  }

	  // Setter
	  public void setCheck(long ccheck) {
	    TCPClient.check = ccheck;
	  }

}