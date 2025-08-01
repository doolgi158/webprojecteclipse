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

//입력 양식 enter 제거 또는 검색 기능 부여
$("#keyword").on("keydown", function(event) {
	if(event.key === "Enter") {
		event.preventDefault();
		//$("#searchData").click();	// 검색 버튼 클릭과 동일한 동작 실행
	}
});

$("#search").on("change", function() {
	const selected = $(this).val();
	
	if(selected === "all") {
		$("#keyword").val("").attr("placeholder", "");
	}else {
		$("#keyword")
			.val("")
			.attr("placeholder", "검색어 입력");
	}
});

// 검색 버튼 클릭 시 처리 이벤트
$("#searchData").on("click", () => {
	const searchType = $("#search").val();
	
	if(searchType !== "all") {
		if(!checkForm("#keyword", "검색어를")) return;
	}else {
		$("#keyword").val("");	// '전체' 선택 시 검색어 초기화
	}
	
	actionProcess("#f_search", "post", "/board/getBoardList.do");
});