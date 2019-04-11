package com.mulcam.j0123;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {
	Connection conn;
    Statement stmt;   
    ResultSet rs;
	
	public MemberDAO(){
		try {
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
	
    public boolean selectLogin(String id, String pwd) {
       //로그인 성공시 true 리턴	
    	
       connect();
       
       try {
		String sql="select count(*) cnt from member "
		   		+ "where id='"+id+"' and pwd='"+pwd+"'";
		   //ID입력값 ==> a' or 1=1 --
		           //where id='a' or 1=1 --
		   stmt = conn.createStatement();
		   rs = stmt.executeQuery(sql);
		   
		   rs.next(); //한 행 얻어오기
		   //rs.getInt(1);
		   int cnt = rs.getInt("cnt");
		   if(cnt > 0) return true;
	    } catch (SQLException e) {
		   e.printStackTrace();
	    } finally {
	    	disconnect();
		}
       return false;
    }//selectLogin
	
	
}









