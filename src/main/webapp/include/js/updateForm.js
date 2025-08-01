$("#boardListBtn").on("click", () => {
	locationProcess("/board/getBoardList.do");
});

$("#boardUpdateBtn").on("click", () =>{
	if(!chkData("#title", "제목을")) return;
	else if (!chkData("#content", "작성할 내용을")) return;
	else {
		actionProcess("#f_updateForm", "post", "/board/updateBoard.do");
	}
});
