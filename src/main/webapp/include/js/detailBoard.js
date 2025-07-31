$("#boardListBtn").on("click", () => {
	locationProcess("/board/getBoardList.do");
});

$("#insertFormBtn").on("click", () => {
	locationProcess("/board/insertForm.do");
});

$("#updateFormBtn").on("click", function(){
	actionProcess("#dataForm", "get", "/board/updateForm.do");
});