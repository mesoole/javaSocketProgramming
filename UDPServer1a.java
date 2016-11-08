import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer1a {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DatagramSocket serverSocket = new DatagramSocket(9876);

		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];

		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);

			String sentence = new String(receivePacket.getData());

			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();

			// String capitalizedSentence = sentence.toUpperCase();

			// sendData = capitalizedSentence.getBytes();

			String modifiedSentence = "HEllo " + sentence;
			sendData = modifiedSentence.getBytes();
			
			System.out.println(modifiedSentence);
			
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

			serverSocket.send(sendPacket);
		}
	}

}
