package socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
public static void main(String[] args) throws Exception {
	//3.서버소켓에 접속 시도 
	//Socket s = new Socket(String host, int port); 
	Socket s = new Socket("70.12.247.207", 5000); 
	
	
}
}
