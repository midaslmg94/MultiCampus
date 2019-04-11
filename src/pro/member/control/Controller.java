package pro.member.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import pro.member.model.MemberDAO;
import pro.member.model.MemberVO;
import pro.member.view.InputForm;
import pro.member.view.MainView;
import pro.member.view.UpdateForm;


public class Controller implements ActionListener{
   //뷰등록
   MainView mainView;
   InputForm form;//입력폼
   UpdateForm upform;//수정폼
	
   public Controller() {
	  mainView = new MainView();
	  form= new InputForm();
	  upform = new UpdateForm();
	  
	  eventUp();
   }	
   
   private void eventUp(){//이벤트 등록
	   //----mainView----
	   mainView.bt_insert.addActionListener(this);
	   mainView.bt_update.addActionListener(this);
	   mainView.bt_delete.addActionListener(this);
	   
	   //----inputForm,upForm----
	   form.bt_submit.addActionListener(this);
	   upform.bt_submit.addActionListener(this);
	   
	   //입력폼의 우측상단 'X'버튼 클릭시  메인화면으로 이동
	   form.addWindowListener(new WindowAdapter() {
		   @Override
		  public void windowClosing(WindowEvent e) {
			  form.setVisible(false);
			  mainView.setVisible(true);
		  }
	   });
	   
	   //수정폼의 우측상단 'X'버튼 클릭시  메인화면으로 이동
	   upform.addWindowListener(new WindowAdapter() {
		   @Override
		   public void windowClosing(WindowEvent e) {
			   upform.setVisible(false);
			   mainView.setVisible(true);
		   }
	   });
	   
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e) {//이벤트 처리부(요청 분석)
	 Object ob = e.getSource();//이벤트 소스의 레퍼런스 얻어오기
	 if(ob==mainView.bt_insert){//메인뷰 입력버튼 클릭
		 mainView.setVisible(false);
		 form.setVisible(true);
	 }else if(ob==form.bt_submit){//입력폼 입력버튼 클릭
		String age =  form.tf_age.getText();
		String name = form.tf_name.getText();
		String job = form.tf_job.getText();
		
		// vo가 3개의 데이터 age, name, job을 참조
		MemberVO vo = new MemberVO(0, name, Integer.parseInt(age), job);
		
		MemberDAO dao = new MemberDAO();
			if(dao.insert(vo)) {
				form.showMsg("입력성공");
				form.setVisible(false); // 현재 보이는 입력폼은 감춤
				mainView.setVisible(true); // 메인뷰로 돌아감
				
			}
		
	 }else if(ob==upform.bt_submit){//수정폼 수정버튼 클릭
		    
	 }else if(ob==mainView.bt_update){//메인뷰 수정클릭
		 mainView.setVisible(false);
		 upform.setVisible(true);
	 }else if(ob == mainView.bt_delete){//메인뷰: 삭제버튼클릭
		 
	 }
	 
   }//actionPerformed
   public static void main(String[] args) {
	   new Controller();
   }

}




