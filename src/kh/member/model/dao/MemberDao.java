package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static kh.common.jdbc.JdbcTemplate.*;
import kh.member.model.vo.MemberVo;

public class MemberDao {
	//아이디 중복 확인
	public int dupIdChk(Connection conn, String id) {
		int result = -1;
		String sql = "select ID from test_member where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(conn);
		}
		
		return result;
	}
	
	
	//내정보보기
	public MemberVo myInfo(Connection conn, String id) {
		MemberVo result = null;
		String sql = "select ID, NAME, EMAIL from test_member "
				+ "where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new MemberVo();
				result.setEmail(rs.getString("EMAIL"));
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	
	// login
	public MemberVo login(Connection conn, MemberVo vo) {
		MemberVo result = null;
		String sql = "select ID, NAME, EMAIL from test_member "
				+ "where id=? and passwd=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new MemberVo();
				result.setEmail(rs.getString("email"));
				result.setId(rs.getString("id"));
				result.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}
	
	
	
	
	
	//회원가입이니까 insert
	public int enroll(Connection conn, MemberVo vo) {
		int result = -1;
		String query= "insert into Test_Member valuse";
		query += " (?,?,?,?)";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			//?채워주기
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			//pstmt 실행
			//결과값 result에 대입
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("DAO enroll() return: "+ result);
		return result;
	}
}
