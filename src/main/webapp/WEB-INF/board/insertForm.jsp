<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/common/header.jsp" %>
<body>
	<div class="container">
		<div class="text-center"><h3>게시판 입력 화면</h3></div>
		
		<form id="f_writeForm">
			<div class="mb-3 row">
				<label for="author" class="col-sm-2 col-form-label">작 성 자</label>
				<div class="col-sm-10">
					<input type="text" id="author" name="author" class="form-control" placeholder="작성자 입력" maxlength="6" />
				</div>
			</div>
			<div class="mb-3 row">
				<label for="title" class="col-sm-2 col-form-label">글 제 목</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" name="title" placeholder="글제목 입력">
				</div>
			</div>
			<div class="mb-3 row">
				<label for="content" class="col-sm-2 col-form-label">글 내 용</label>
				<div class="col-sm-10">
					<textarea name="content" id="content" class="form-control" rows="8"></textarea>
				</div>
			</div>
			<div class="mb-3 row">
				<label for="passwd" class="col-sm-2 col-form-label">비밀번호</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="passwd" name="passwd" placeholder="비밀번호 입력" />
				</div>
			</div>
		</form>
		<div class="text-end">
			<button type="button" class="btn btn-primary" id="boardInsert">글저장</button>
			<button type="button" class="btn btn-primary" id="boardListBtn">글목록</button>
		</div>
	</div>
	<%@ include file="/WEB-INF/common/footer.jsp" %>
	<script src="/include/js/insertForm.js"></script>
	<script>
		let errorMsg = "${ errorMsg }";
		if(errorMsg != ""){
			alert(errorMsg);
			errorMsg = "";
		}
	</script>
</body>
</html>