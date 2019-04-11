package com.mulcam.j0123;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FistJDBC {
   Connection conn;//DB와의 연결
   Statement  stmt;//sql실행(DML,DQL)
   ResultSet  rs;  //select문을 실행한 결과를 저장.
	
   public FistJDBC() {
     try {
		//1.드라이버 로딩  (제품군 선택)
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		  
		 //2.연결객체 생성
		  /*conn = DriverManager.getConnection(String url, 
				                             String user,
				                             String password) */
		  conn = DriverManager.getConnection(
		   //"jdbc:oracle:thin:@연결DB서버IP:포트port:시스템식별자sid");
				  //"jdbc:oracle:thin:@70.12.113.130:1521:xe");
		           "jdbc:oracle:thin:@localhost:1521:xe",
		           "scott","tiger");
		  
		 System.out.println("DB연결 성공~^^*"); 
		  
		  
	} catch (Exception e) {
		e.printStackTrace();
	}
			                             
   }//생성자
	
	
   public static void main(String[] args) {
	   //FistJDBC fj = new FistJDBC();
	    new FistJDBC();
   }
}




