$("#boardListBtn").on("click", () => {
	locationProcess("/board/getBoardList.do");
});

$("#boardUpdateBtn").on("click", () =>{
	actionProcess("#f_updateForm", "post", "/board/updateBoard.do");	
});
