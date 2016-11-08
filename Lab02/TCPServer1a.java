import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer1a {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String clientSentence;

		String capitalizedSentence;

		ServerSocket WelcomeSocket = new ServerSocket(8989);

		while (true) {

			Socket connectionSocket = WelcomeSocket.accept();

			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

			clientSentence = inFromClient.readLine();

			System.out.println(clientSentence);

			capitalizedSentence = "Hello " + clientSentence.toUpperCase() + "\n";

			outToClient.writeBytes(capitalizedSentence);
		}

	}

}
