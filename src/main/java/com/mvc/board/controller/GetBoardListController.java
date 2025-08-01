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
		// 게시판 레코드 검색 시 검색할 대상과 단어를 인자값으로 전달
		String search = request.getParameter("search");
		// 최초 요청시 null 값 처리
		if(search == null) {
			search = "all";	// search 값이 all이면 전체 조회
		}
		
		BoardVO boardVO = new BoardVO();
		boardVO.setSearch(search);
		boardVO.setKeyword(request.getParameter("keyword"));
		
		BoardServiceImpl service = BoardServiceImpl.getInstance();
		//List<BoardVO> list = service.boardList();
		List<BoardVO> list = service.boardList(boardVO);
				
		request.setAttribute("list", list);
		// jsp 페이지에서 사용방법은 ${ requestScope.list } 또는 ${ list }
		
		return "/board/getBoardList";
	}
}
