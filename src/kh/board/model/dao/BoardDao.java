package kh.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kh.board.model.vo.BoardVo;
import kh.common.jdbc.JdbcTemplate;


public class BoardDao {

	public List<BoardVo> getBoardList(Connection conn){
		List<BoardVo> result = null;
		String spl ="";
		// 큰따옴표 안에는 세미콜론 없어야 함, 캐리지 리턴 |r|n도 없애기
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 다중행
			result = new ArrayList<BoardVo>();
			while(rs.next()) {
				BoardVo vo = new BoardVo();
				vo.setBoardContent(rs.getString("board_Content"));
				vo.setBoardDate(rs.getDate("Board_Date"));
				vo.setBoardLevel(rs.getInt("BoardLevel"));
				vo.setBoardNum(rs.getInt("Board_Num"));
				vo.setBoardOriginalFilename(rs.getString("boardOriginalFilename"));
				vo.setBoardRenameFilename(rs.getString("BoardRenameFilename"));
				vo.setBoardReplySeq(rs.getInt("Reply_Seq"));
				vo.setBoardTitle(rs.getString("board_Title"));
				vo.setBoardWriter(rs.getString("Board_Writer"));
				result.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcTemplate.close(rs);
			JdbcTemplate.close(pstmt);
		}
		
		return result;
	}
}
