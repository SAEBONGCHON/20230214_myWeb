package kh.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kh.board.model.vo.BoardVo;
import kh.common.jdbc.JdbcTemplate;


public class BoardDao {
	//페이징처리를 위한 메소드를 오버로딩!!!!!!!!!!!!! 응 ? 잘못함 아래내용 아님
		public int getCountBoard(Connection conn, int srnum, int ernum) {
			int result = 0; 
			String sql = "페이징을 위한 서브쿼리를 입력해야함.";
			PreparedStatement pstmt =null;
			ResultSet rs = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt = setInt(?, srnum);
				pstmt = setInt(?, ernum);
				
				rs =pstmt.executeQuery();
				if(rs.next()) {
//				result = rs.getInt("cnt");				
				result = rs.getInt(1);				
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(pstmt);
			}
			return result;
		}
	//페이징처리를 위한 메소드
	public int getCountBoard(Connection conn) {
		int result = 0; 
		String sql = "select count(*) cnt from board";
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs =pstmt.executeQuery();
			if(rs.next()) {
//			result = rs.getInt("cnt");				
			result = rs.getInt(1);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
		//select니까 executeQuery에 담는 것일거고,, 프리페어드스테이트먼트를 사용하나?
		// 모르겟다 ㅎㅎ
	}

	public List<BoardVo> getBoardList(Connection conn){
		List<BoardVo> result = null;
		String sql ="";
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
