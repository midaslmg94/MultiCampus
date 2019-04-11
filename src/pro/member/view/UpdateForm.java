package pro.member.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateForm extends JFrame{
	 JLabel la_name,la_age,la_job;
	 public JTextField tf_name, tf_age, tf_job;
	 
	 public JButton bt_submit, bt_cancel;
	 
     public UpdateForm() {
    	 setTitle("수정폼");
    	 la_name = new JLabel("이름");
    	 la_age = new JLabel("나이");
    	 la_job = new JLabel("직업");
    	 
    	 tf_name  = new JTextField();
    	 tf_age  = new JTextField();
    	 tf_job  = new JTextField();
    	 
    	 bt_submit = new JButton("수정");
    	 bt_cancel = new JButton("취소");
    	 
    	 setLayout(null);
    	 
    	 la_name.setBounds(30, 30, 40, 30);
    	 la_age.setBounds(30, 80, 40, 30);
    	 la_job.setBounds(30, 130, 40, 30);
    	 
    	 tf_name.setBounds(70, 30, 80, 30);
    	 tf_age.setBounds(70, 80, 80, 30);
    	 tf_job.setBounds(70, 130, 80, 30);
    	 
    	 bt_submit.setBounds(30, 180, 60, 30);
    	 bt_cancel.setBounds(100, 180, 60, 30);
    	 
    	 add(la_name);
    	 add(la_age);
    	 add(la_job);
    	 add(tf_name);
    	 add(tf_age);
    	 add(tf_job);
    	 add(bt_submit);
    	 add(bt_cancel);
    	 
         setBounds(620,220,200,280);
         //setVisible(true);
         setResizable(false);
         //setDefaultCloseOperation(EXIT_ON_CLOSE);
    	 
	 }//생성자
     
              
     public void showMsg(String msg){
    	 JOptionPane.showMessageDialog(this, msg);
     }//showMsg
     
    
     
}








