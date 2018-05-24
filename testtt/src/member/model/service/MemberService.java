package member.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {

	public Member SelectOne(String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().SelectOne(conn, userId, userPwd);
		
		JDBCTemplate.close(conn);
		
		return m;
	}

}
