package socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server extends Thread{
//1.서보소켓객체 생성
	ServerSocket ss; 
	
	Vector<Service> v; //접속한 클라이언트 정보들을 저장, 관리 
	
	public Server() {
		v= new Vector<Service>();
		//ss = new ServerSocket(int port);
		try {
			ss = new ServerSocket(5000);//1.서브소켓객체 생성
			System.out.println("start server");
			start(); //start()하는 순간 run()실행 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void run() {
		try {
			while(true) {
				//2. 클라이언트 접속 대기 
				Socket s = ss.accept();
				
				Service serv = new Service(s,v);
				v.add(serv); 
				
				InetAddress ia = s.getInetAddress(); 
				System.out.println("클라이언트 접속"+ia.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {

	new Server(); 
}
}
