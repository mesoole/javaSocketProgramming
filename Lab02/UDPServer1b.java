import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer1b {

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

			sendData = "Server1 /n".getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

			serverSocket.send(sendPacket);

			String recieveSentence = new String(receivePacket.getData());

			String ModifiedSentence = sentence.toUpperCase();

			System.out.println(ModifiedSentence);

		}
	}

}
