package com.mvc.board.service;

import java.util.List;

import com.mvc.board.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> boardList();
	public List<BoardVO> boardList(BoardVO boardVO);
	public int boardInsert(BoardVO boardVO);
	public void readcntUpdate(BoardVO boardVO);
	public BoardVO boardDetail(BoardVO boardVO);
	public BoardVO updateForm(BoardVO boardVO);
	public int boardUpdate(BoardVO boardVO);
	public int boardDelete(BoardVO boardVO);
	public int boardPasswdCheck(BoardVO boardVO);
}