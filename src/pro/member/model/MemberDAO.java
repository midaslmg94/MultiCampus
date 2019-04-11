package pro.member.model;

import org.apache.ibatis.session.SqlSession;

import mybatis.MySqlSession;

public class MemberDAO { //DB 전담 클래스(Database Access Object)
	// --> CRUD 작업 Create(insert), Read(select), Update, Delete
	
	SqlSession session = MySqlSession.getSqlSession();
	
	public boolean insert(MemberVO vo) {
//		session.insert("네임스페이스명.아이디명",Object parameter);
		session.insert("member.insert",vo);
		session.commit();
		return true;
	}
	
	
	
}
