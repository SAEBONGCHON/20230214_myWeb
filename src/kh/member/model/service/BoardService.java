package kh.member.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import kh.board.model.dao.BoardDao;
import kh.board.model.vo.BoardVo;
import kh.common.jdbc.JdbcTemplate;


public class BoardService {
	public int getCountBoard() {
		int result = 0; 
		Connection conn =getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		return result;
	}
		//TODO: 마저 작성해야함
	
	//overloading
	public List<BoardVo> getBoardList(int srnum, int ernum){
		List<BoardVo> result = null;
		Connection conn = JdbcTemplate.getConnection();
		result = new BoardDao().getBoardList(conn, srnum, ernum);
		JdbcTemplate.close(conn);
		return result;
	}
	
	
	public List<BoardVo> getBoardList(){
		List<BoardVo> result = null;
		Connection conn = JdbcTemplate.getConnection();
		result = new BoardDao().getBoardList(conn);
		JdbcTemplate.close(conn);
		return result;
	}
}
