package javaPing;

import java.io.*;
import java.net.*;
import java.util.*;

/*
 * Server to process ping requests over UDP.
 */

public class PingClient {
	private static final double LOSS_RATE = 0.3;
	private static final int AVERAGE_DELAY = 100; // milliseconds

	public static void main(String[] args) throws Exception {
		// Get command line argument.
		if (args.length != 2) {
			System.out.println("Required arguments: ip port");
			return;
		}

		// convert to Net Address
		InetAddress serverIP = InetAddress.getByName(args[0]);
		// set the Server Port
		int port = Integer.parseInt(args[1]);

		// Create a datagram socket for receiving and sending UDP packets
		// through the port specified on the command line.
		DatagramSocket socket = new DatagramSocket();
		socket.setSoTimeout(1000);// after 1 Second time out catch

		// Processing loop.
		for (int i = 1; i <= 10; i++) {
			long time = System.currentTimeMillis();
			byte[] buf = ("PING #" + i + " " + time + "\r\n").getBytes();
			DatagramPacket UDPPacket = new DatagramPacket(buf, buf.length, serverIP, port);
			socket.send(UDPPacket);
			//Incoming UDP Packet
			DatagramPacket request = new DatagramPacket(new byte[1024], 1024);

			try {
				socket.receive(request);
				printData(request);
			} catch (SocketTimeoutException ex) {
				continue;
			}

		}
	}

	/*
	 * Print ping data to the standard output stream.
	 */
	private static void printData(DatagramPacket request) throws Exception {
		// Obtain references to the packet's array of bytes.
		byte[] buf = request.getData();

		// Wrap the bytes in a byte array input stream,
		// so that you can read the data as a stream of bytes.
		ByteArrayInputStream bais = new ByteArrayInputStream(buf);

		// Wrap the byte array output stream in an input stream reader,
		// so you can read the data as a stream of characters.
		InputStreamReader isr = new InputStreamReader(bais);

		// Wrap the input stream reader in a bufferred reader,
		// so you can read the character data a line at a time.
		// (A line is a sequence of chars terminated by any combination of \r
		// and \n.)
		BufferedReader br = new BufferedReader(isr);

		// The message data is contained in a single line, so read this line.
		String line = br.readLine();

		// Print host address and data received from it.
		System.out.println("Received from " + request.getAddress().getHostAddress() + ": " + new String(line));
	}

}
