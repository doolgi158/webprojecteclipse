package com.mvc.board.service;

import java.util.List;

import com.mvc.board.dao.BoardDAO;
import com.mvc.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService{
	private static BoardServiceImpl service = null;
	private BoardDAO dao;
	
	private BoardServiceImpl() {
		dao = BoardDAO.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<BoardVO> boardList() {
		List<BoardVO> list = dao.boardList();
		return list;
	}
}
