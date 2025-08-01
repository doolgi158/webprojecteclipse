package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.board.service.BoardService;
import com.mvc.board.service.BoardServiceImpl;
import com.mvc.board.vo.BoardVO;
import com.mvc.common.controller.Controller;

public class PasswdCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		String passwd = request.getParameter("passwd");
		
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(Integer.parseInt(num));
		boardVO.setPasswd(passwd);
		
		BoardService service = BoardServiceImpl.getInstance();
		int result = service.boardPasswdCheck(boardVO);
		
		request.setAttribute("resultData", result);
		
		return "/common/resultData";
	}

}
