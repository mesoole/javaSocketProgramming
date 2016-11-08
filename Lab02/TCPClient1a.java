import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient1a {

	public static void main(String[] args) throws Exception {//rgelfand@mum.edu
		// TODO Auto-generated method stub

		String sentence = "";

		String modifiedSentence = "";

		String srvAddress = "127.0.0.1";

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		Socket clientSocket = new Socket(srvAddress, 8989);

		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		System.out.println("Please WriteDown Your Name:");

		sentence = inFromUser.readLine();

		outToServer.writeBytes(sentence + '\n');

		modifiedSentence = inFromServer.readLine();

		outToServer.writeBytes("FROM SERVER: " + modifiedSentence);

		System.out.println(modifiedSentence);

		clientSocket.close();

	}

}
