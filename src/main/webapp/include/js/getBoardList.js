$("#writeForm").on("click", function(){
	//console.log("글쓰기 버튼 클릭");	// 콘솔에 출력하는 이유는 이벤트가 정상적으로 실행되는지 확인하기 위해서 명시
	locationProcess("/board/insertForm.do");
});

$(".goDetail").on("click", function(){
	const $row = $(this).closest("tr");
	const num = $row.data("num");
	console.log("num = " + num);
	
	// 폼 태그 내 num요소에 value 설정. post 방식으로 상세 페이지 이동
	$("#num").val(num);
	actionProcess("#detailForm", "post", "/board/detailBoard.do");
	
	// get 방식으로 상세 페이지 이동
	//locationProcess(`/board/detailBoard.do?num=${ num }`);
});