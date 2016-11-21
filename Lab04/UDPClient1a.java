package javaPing;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

public class UDPClient1a {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		DatagramSocket clientSocket = new DatagramSocket();

		InetAddress IPAddress = InetAddress.getByName("127.0.0.1");

		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];

		String sentence = inFromUser.readLine();
		sendData = sentence.getBytes();

		DatagramPacket sendPacekt = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
		clientSocket.send(sendPacekt);

		DatagramPacket recievePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(recievePacket);

		String modifiedSentence = new String(recievePacket.getData());

		System.out.println("FROM SERVER:" + modifiedSentence);
		clientSocket.close();

	}

}
