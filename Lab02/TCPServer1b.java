import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer1b {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String clientSentence;

		String capitalizedSentence;

		ServerSocket WelcomeSocket = new ServerSocket(8988);

		while (true) {

			Socket connectionSocket = WelcomeSocket.accept();

			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			capitalizedSentence = "Server1b \n";

			outToClient.writeBytes(capitalizedSentence);
			
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			
			clientSentence = inFromClient.readLine();

			System.out.println(clientSentence);
		}

	}

}
