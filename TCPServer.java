import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket listener = new ServerSocket(8989);
		try{
			while(true)
			{
				Socket socket = listener.accept();
				try{
					System.out.println(socket.getOutputStream());
//					System.out.println("hi");
				}
				finally {
					socket.close();
				}
			}
		}
		finally{
			listener.close();
		}

	}

}
