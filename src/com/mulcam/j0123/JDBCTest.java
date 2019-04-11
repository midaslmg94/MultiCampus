package com.mulcam.j0123;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
   public static void main(String[] args)throws Exception {
	 //<JDBC Programming>
	 //1. 드라이버 로딩 (제품군 선택)
	  //Class.forName("패키지명.클래스명"); 
	  Class.forName("oracle.jdbc.driver.OracleDriver"); 
	   
	 //2. DB연결 (Connection객체 생성)
	  Connection conn = DriverManager.getConnection
			    ("jdbc:oracle:thin:@localhost:1521:xe",
			    		"scott","tiger"); 
	   
	 //3. sql문 실행 (Statement객체 생성) - DML, DQL
	  Statement stmt = conn.createStatement();
	  
	  String sql="delete from emp2 where deptno=30";
	  
	  //실행메소드1:  stmt.executeUpdate("DML문장") - 리턴: int
	  //실행메소드2:  stmt.executeQuery("DQL문장")  - 리턴: ResultSet
	  
	  int t = stmt.executeUpdate(sql);//t: 삭제한 행의 갯수!!
	  System.out.println("삭제된 행의 수: "+ t);
	   
//----------------- DML -----------------------------------
	   
	  
	  
	 //4. 조회 결과값(행열데이터) 얻기 (ResultSet객체 생성)  
//----------------- DQL -----------------------------------	   
	  sql="select empno,ename from emp";//예상 행열? 14행 2열
	  
	  ResultSet rs = stmt.executeQuery(sql);
	 
	  /*
	  //한 행 얻어오기
	  rs.next(); //리턴 boolean
	  
	  //행 안의 열 데이터 얻어오기
	  System.out.println(rs.getInt(1));   
	                      //첫번째 열인덱스 데이터  또는 컬럼명  	  
	  System.out.println(rs.getString(2));
	                       //두번째 열인덱스 데이터 또는 컬럼명
	  */
	  
	  while(rs.next()) {//얻어올 행이 있다면
		 System.out.println("사번:"+ rs.getInt("empno")); 
		 System.out.println("사원명:"+ rs.getString("ename"));
		 System.out.println("------------------------------");
	  }
	  
	  
	   
	   
	   
   }
}




