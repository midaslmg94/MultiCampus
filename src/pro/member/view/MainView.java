package pro.member.view;

import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainView extends JFrame implements Runnable {
	public JTable table;
	JLabel la;
	JPanel northp;
	DefaultTableModel dtm;
    
	public JButton bt_insert, bt_update, bt_delete, bt_exit;
	JPanel southp;
	
	public MainView() {
		setTitle("MainView");
		
		//자료형 배열명[] = new 자료형[배열크기];
		Object rowData[][]= new String[0][4];//행사이즈 0 : 데이터 행의 시작 인덱스
		
		Object colNames[]={"번호", "이름", "나이", "직업"};	
		
		//JTable(Object[][] rowData, Object[] columnNames) 
		//JTable(TableModel dm) 
		//TableModel(인터페이스)  
		//----->구현 DefaultTableModel(Object[][] data, Object[] columnNames) 
		
		dtm = new DefaultTableModel(rowData, colNames);
		//dtm을 사용하는 이유: dtm에는 JTable에 행을 추가, 삭제하는 메소드가 존재!!
		table = new JTable(dtm);		

		JScrollPane scrol = new JScrollPane(table); 
		
		la = new JLabel("JTable 안녕~!!");
		
		northp = new JPanel();
		  northp.add(la);
		  
	    bt_insert = new JButton("입력");
	    bt_update = new JButton("수정");
	    bt_delete = new JButton("삭제");
	    bt_exit = new JButton("종료");
	    
	    southp = new JPanel();
	      southp.add(bt_insert);
	      southp.add(bt_update);
	      southp.add(bt_delete);
	      southp.add(bt_exit);
		add("North", northp);
		add("Center", scrol);//table);
		add("South", southp);
		
		//getTime();
		Thread t = new Thread(this);
		t.start();
		
		setBounds(300,200,300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		
	}//생성자	
	public void run() {//public void getTime() {
		// 현재 흘러가는 시간을 표시 --> 쓰레드사용
		try {
			while(true) {
				Calendar cal = Calendar.getInstance();
				int h = cal.get(Calendar.HOUR);
				int m = cal.get(Calendar.MINUTE);
				int s = cal.get(Calendar.SECOND);
				
				String str = h+"시 "+m+"분 "+s+"초";
				la.setText(str);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	public void displayTable(){		
		
	}//displayTable
	
	public void showMsg(String msg){
   	 JOptionPane.showMessageDialog(this, msg);
        }//showMsg
	}//MainView class







