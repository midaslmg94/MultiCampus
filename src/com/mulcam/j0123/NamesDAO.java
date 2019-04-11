package com.mulcam.j0123;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NamesDAO 
{
    Connection conn;
    Statement stmt;   
    ResultSet rs;

	public NamesDAO(){
		try {
			//1.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}//생성자
	
	
	private void connect() {//DB연결작업
		try {
			conn=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe",
							"scott","tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	private void disconnect() {//DB자원 반환
		  try {
				if(rs != null)rs.close(); 
				if(stmt != null)stmt.close(); 
				if(conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	public void insert(String name){
	  connect();	
	  try {
		  //3.
		  stmt = conn.createStatement();		
		  String sql="insert into names (name) values ('"+name+"')";
		  System.out.println("입력sql==>"+sql);
		  stmt.executeUpdate(sql);//sql문 실행 요청 --> 실행시점
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
	   disconnect();	
	}
	  
	}//insert

    public void select(){//전체이름출력
    	connect();
		try {
			System.out.println("# 이름목록");
			 	
			  //3.
			  stmt = conn.createStatement();		
			  String sql="select name from names";
	
			  //4.
			  rs = stmt.executeQuery(sql);//sql문 실행 요청 --> 실행시점
			  //rs --> 결과 집합 : 조회된 행열
			  while(rs.next()) { //한행 얻기 : 얻어올 행이 있다면 
				  //행안의 열데이터 뽑기
				  System.out.println(" "+ rs.getString("name"));
			  }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		 
	}//select
    
    public void update(String oldName, String newName){      
	    connect();
    	
       try {
	//String sql="update names set name='나길동' where name='홍길동'";
	 String sql="update names set name='"+newName+
			              "' where name='"+ oldName+"'";
	      System.out.println("수정sql==>"+ sql);
	    	
	        stmt = conn.createStatement();
	        int t = stmt.executeUpdate(sql);//수정요청, 수정되는 시점
	    	//t: 수정된 행의 갯수
	        System.out.println("수정T="+t);
	        
	        if(t>0)
			  System.out.println("# 이름수정 성공!!");
	        else
			System.out.println("# 이름수정 실패!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		   disconnect();
		}
	}//update
    
    public void delete(String delName){
      connect();	
      
      try {
		stmt = conn.createStatement();
		  //String sql="delete from names where name='홍길동'";    	
		  String sql="delete from names where name='"+delName+"'";
		  int t = stmt.executeUpdate(sql); //t: 삭제된 행의 갯수
		  
		  if(t>0) {
			  System.out.println("# 이름삭제 성공!!");  
		  }else {
			  System.out.println("# 존재하지 않는 이름입니다!!");
		  }
	   } catch (SQLException e) {
		e.printStackTrace();
	   }
      
      disconnect();
	}//delete
    
}







