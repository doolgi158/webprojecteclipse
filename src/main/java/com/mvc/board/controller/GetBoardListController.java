package com.mvc.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardServiceImpl;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;

public class GetBoardListController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		List<BoardVO> list = service.boardList();
		
		request.setAttribute("list", list);
		// jsp 페이지에서 사용방법은 ${ requestScope.list } 또는 ${ list }
		
		return "/board/getBoardList";
	}
}
