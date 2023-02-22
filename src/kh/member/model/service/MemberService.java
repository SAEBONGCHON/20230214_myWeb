package kh.member.model.service;

import java.sql.Connection;

import static kh.common.jdbc.JdbcTemplate.*;
import kh.member.model.dao.MemberDao;
import kh.member.model.vo.MemberVo;

public class MemberService {
	//아이디중복확인
	public int dupIdChk(String id) {
		Connection conn = getConnection();
		int result = new MemberDao().dupIdChk(conn, id);
		close(conn);
		return result;
	}
	
	//마이인포
	public MemberVo myInfo(String id) {
		MemberVo result = null;
		Connection conn = getConnection();
		result = new MemberDao().myInfo(conn, id);
		close(conn);
		return result;
	}
	//로그인
	public MemberVo login(MemberVo vo) {
		MemberVo result = null;
		Connection conn = getConnection();
		result = new MemberDao().login(conn, vo);
		close(conn);
		return result;
	}
	//회원가입이니까 insert
		public int enroll(MemberVo vo) {
			int result = -1;
			Connection conn = getConnection(); 
			result = new MemberDao().enroll(conn, vo);
			close(conn);
			
			return result;
		}
}
