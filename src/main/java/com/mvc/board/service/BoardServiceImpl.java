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

	@Override
	public int boardInsert(BoardVO boardVO) {
		int result = dao.boardInsert(boardVO);
		return result;
	}

	@Override
	public void readcntUpdate(BoardVO boardVO) {
		dao.readCount(boardVO);
	}

	@Override
	public BoardVO boardDetail(BoardVO boardVO) {
		BoardVO board = dao.boardDetail(boardVO);
		board.setContent(board.getContent().replaceAll("\n", "<br />"));
		return board;
	}

	@Override
	public BoardVO updateForm(BoardVO boardVO) {
		BoardVO board = dao.boardDetail(boardVO);
		return board;
	}

	@Override
	public int boardUpdate(BoardVO boardVO) {
		int result = dao.boardUpdate(boardVO);
		return result;
	}
}
