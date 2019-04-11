package com.mulcam.j0124;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.MySqlSession;

public class NamesDAO 
{
	SqlSession session;
	
	public NamesDAO() {
	  session = MySqlSession.getSqlSession();
	}
	
    public void insert(String name) {
      //session.insert(String id)	
      //session.insert(String id,Object param)	
      session.insert("names.insert",name);
      session.commit();
    }   
    public void delete(String delName) {
      session.delete("names.delete",delName);
      session.commit();
    }   
    public void update(String oldName,String newName) {
      Map<String, String> map = new HashMap<String, String>();
        //map.put(String key, String value);
        map.put("oldName", oldName);
        map.put("newName", newName);
      session.update("names.update", map);
      session.commit();
    }   
    public void select() {
    	//session.selectOne("패키지명.아이디명"); ==> 결과행이 한행 일때
    	//session.selectList("패키지명.아이디명"); ==> 결과행이 두개 이상일때
      List<String> list = session.selectList("names.selectAll");
        for( String name : list) {
        	System.out.println(" "+ name);
        }
    }   
}







