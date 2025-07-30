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
}