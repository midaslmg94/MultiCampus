package com.mulcam.j0123;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO2 {
	Connection conn;
    PreparedStatement stmt;//sql문을 먼저 DB에 전달, 데이터는 실행시 전달   
    ResultSet rs;
	
	public MemberDAO2(){
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
		   		+ "where id=? and pwd=?";
		   //ID입력값 ==> a' or 1=1 --
		   stmt = conn.prepareStatement(sql);//미리 sql문만 보내기
		      //?의 수만큼 세팅
		     //stmt.setString(int parameterIndex,String x);
		      stmt.setString(1, id);//1: 첫번째 물음표
		      stmt.setString(2, pwd);//2: 두번째 물음표
		   rs = stmt.executeQuery();//실행요청!!
		   
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









