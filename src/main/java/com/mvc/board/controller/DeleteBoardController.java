package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardService;
import com.mvc.board.service.BoardServiceImpl;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;

public class DeleteBoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
	
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(Integer.parseInt(num));
		
		BoardService service = BoardServiceImpl.getInstance();
		service.boardDelete(boardVO);
	
		return "/board/getBoardList.do";
	}

}
