package socket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener, Runnable{
	
	JTextArea ta ; 
	JTextField tf_send; 
	JScrollPane scrol_ta; 
	
	Socket s ;  
	
	//소켓 입출력 객체 
	Scanner in; 
	OutputStream out; 
	
	public ChatClient() {
	setTitle("대화방");
	scrol_ta = new JScrollPane(ta); 
	
	tf_send = new JTextField(); 
	
	add("Center", scrol_ta); 
	add("South", tf_send); 
	
	setBounds(200,100,300,400);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);

	tf_send.addActionListener(this); 
	
	connect(); 
	
	new Thread(this).start(); 
	
	
	}//생성자
	
	//서버 접속
	
	public void connect() {
		
		try {
			//3.서버 접속
			s = new Socket("70.12.113.130", 5000);
			
			//4.소켓 입출력 객체 생성
			in = new Scanner(s.getInputStream());
			out = s.getOutputStream(); 
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	//서버가 보내는 메시지를 받아서 TextArea출력
	public void run() {
		while(true) {
			String msg = in.nextLine();
			ta.append(msg+"\n");
			
			ta.setCaretPosition(ta.getText().length());
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		//System.out.println("액션");
		String str = tf_send.getText(); 
		str = str+"\n"; //라인구분
		//5.서버에게 write()
		try {
			out.write(str.getBytes());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		tf_send.setText("");
	
	}
	
 public static void main(String[] args) {
new ChatClient(); 	
}
}
