<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/common/header.jsp" %>  

<body>
	<div class="container">
		<div class="text-center">
			<img src="https://cdn-icons-png.flation.com/512/2748/2748558.png" alt="서비스 오류 이미지" class="error-image">
			
			<p class="fs-3 text-danger-emphasis">잠시 후 다시 확인해 주세요</p>
			<p>
				지금 이 서비스와 연결할 수 없습니다.<br />
				문제를 해결하기 위해 열심히 노력하고 있습니다.<br />
				잠시 후 다시 확인해주세요.
			</p>
			<button type="button" id="boardListBtn" class="btn btn-warning">게시판 리스트</button>
		</div>
	</div>

	<%@ include file="/WEB-INF/common/footer.jsp" %>
	<script>
		$("#boardListBtn").on("click", function(){
			locationProcess("/board/getBoardList.do")
		});
	</script>
</body>
</html>