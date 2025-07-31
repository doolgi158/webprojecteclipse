package com.mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.board.vo.BoardVO;

import static com.mvc.common.util.DBUtil.getConnection;

public class BoardDAO {
	private static BoardDAO instance = null;
	
	public static BoardDAO getInstance() {	// BoardDAO의 인스턴스는 BoardDAO.getInstance()
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	private BoardDAO() {	}	// 다른 클래스 new BoardDAO(); X
	
	private BoardVO addBoard(ResultSet rs) throws SQLException {
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(rs.getInt("num"));
		boardVO.setAuthor(rs.getString("author"));
		boardVO.setTitle(rs.getString("title"));
		boardVO.setWriteday(rs.getString("writeday"));
		boardVO.setReadcnt(rs.getInt("readcnt"));
		return boardVO;
	}
	
	public List<BoardVO> boardList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT NUM, AUTHOR, TITLE, ");
		query.append("TO_CHAR(WRITEDAY, 'YYYY/MM/DD') WRITEDAY, READCNT ");
		query.append("FROM BOARD ");
		query.append("ORDER BY NUM DESC");
	
		try(Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString());
			ResultSet rs = pstmt.executeQuery()){
		
			while(rs.next()) {
				list.add(addBoard(rs));
			}
		}catch(SQLException e) {
			System.err.println("[boardList] SQL 오류: " + e.getMessage());
			//se.printStackTrace(); // 오류 발생 시 주석 해제
		}
		return list;
	}

	public int boardInsert(BoardVO boardVO) {
		/*String query = """
		 * 	INSERT INTO BOARD (NUM, AUTHOR, TITLE, CONTENT, PASSWD)
		 * 	VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, ?)
		 */
		
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO BOARD(NUM, AUTHOR, TITLE, CONTENT, PASSWD) ");
		query.append("VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, ?)");
		
		int result = 0;
		
		try(Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString())) {	// 주석 부분을 해제하고 사용한다면 query.toString() -> query로 변경.
			
			pstmt.setString(1, boardVO.getAuthor());
			pstmt.setString(2, boardVO.getTitle());
			pstmt.setString(3, boardVO.getContent());
			pstmt.setString(4, boardVO.getPasswd());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			System.err.println("[boardInsert] SQL 오류: " + e.getMessage());
			//e.printStackTrace();	// 오류 발생 시 주석 해제
		}
		
		return result;
	}

	public void readCount(BoardVO boardVO) {
		StringBuilder query = new StringBuilder();
		query.append("UPDATE BOARD SET READCNT = READCNT + 1 ");
		query.append("WHERE NUM = ?");
		
		try(Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString());) {
			pstmt.setInt(1,boardVO.getNum());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.err.println("[readCount] SQL 오류: " + e.getMessage());
			//e.printStackTrace();	// 오류 발생 시 주석 해제
		}
	}

	public BoardVO boardDetail(BoardVO boardVO) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT NUM, AUTHOR, TITLE, CONTENT, ");
		query.append("TO_CHAR(WRITEDAY, 'YYYY-MM-DD HH24:MI:SS') WRITEDAY, READCNT ");
		query.append("FROM BOARD WHERE NUM = ?");
		BoardVO resultData = null;
		
		try(Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
			pstmt.setInt(1, boardVO.getNum());
			try(ResultSet rs = pstmt.executeQuery()) {
				if(rs.next()) {
					resultData = addBoard(rs);
					resultData.setContent(rs.getString("content"));
				}
			}
		}catch(SQLException e) {
			System.err.println("[boardDetail] SQL 오류: " + e.getMessage());
			//e.printStackTrace();	// 오류 발생 시 주석 해제
		}
		return resultData;
	}

	public int boardUpdate(BoardVO boardVO) {
		StringBuilder query = new StringBuilder();
		query.append("UPDATE BOARD ");
		query.append("SET TITLE = ?, CONTENT = ?, PASSWD = ? WHERE NUM = ?");
		
		int result = 0;
		
		try(Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString())) {	// 주석 부분을 해제하고 사용한다면 query.toString() -> query로 변경.
			
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getContent());
			pstmt.setString(3, boardVO.getPasswd());
			pstmt.setInt(4, boardVO.getNum());
			
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			System.err.println("[boardUpdate] SQL 오류: " + e.getMessage());
			//e.printStackTrace();	// 오류 발생 시 주석 해제
		}
		
		return result;
	}
}