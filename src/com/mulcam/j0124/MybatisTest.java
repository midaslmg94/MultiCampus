package com.mulcam.j0124;

import org.apache.ibatis.session.SqlSession;

import mybatis.MySqlSession;

public class MybatisTest {
	
	public static void main(String[] args) {
		//XML문서내의 sql을 호출하고 싶다!!
		//필요한 객체: SqlSession !!
	  SqlSession session = MySqlSession.getSqlSession();
      //session.delete(String id)	  
      //session.delete(String id, Object param)
	  int t = session.delete("test.del");
	  //t: 삭제한 행의 갯수	  
	  System.out.println("T="+t);
	  session.commit();
	  System.out.println("삭제 성공!!");
	  
	  
	  
	}

}





