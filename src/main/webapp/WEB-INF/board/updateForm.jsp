<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/common/header.jsp" %>    
<body>
	<div class="container">
		<div class="text-center"><h3>게시판 상세 화면</h3></div>
		<form id="f_updateForm">
			<div class="text-center">
				<%-- 반드시 수정할 글번호를 서버에 전달해 주어야 한다 --%>
				<input type="hidden" name="num" id="num" value="${ updateData.num }">
				<table class="table table-bordered">
					<tr>
						<td class="text-center">글번호</td>
						<td class="text-start">${ updateData.num }<span>(조회수: ${ updateData.readcnt })</span></td>
						<td class="text-center">작성일</td>
						<td class="text-start">${ updateData.writeday }</td>
					</tr>
					<tr>
						<td class="text-center">작성자</td>
						<td colspan="3" class="text-start">${ updateData.author }</td>
					</tr>
					<tr>
						<td class="text-center">글제목</td>
						<td colspan="3">
							<input type="text" name="title" id="title" value="${ updateData.title }" class="form-control" />	
						</td>
					</tr>
					<tr>
						<td class="text-center">글내용</td>
						<td colspan="3">
							<textarea name="content" id="content" rows="8" class="form-control">${ updateData.content }</textarea>
						</td>
					</tr>
					<tr>
						<td class="text-center">비밀번호</td>
						<td colspan="3">
							<input type="password" name="passwd" id="passwd" class="form-control" placeholder="기존 비밀번호가 아니라 수정할 비밀번호를 입력해 주세요." />
						</td>
					</tr>
				</table>
			</div>
		</form>
		
		<div class="text-end">
			<button type="button" id="boardUpdateBtn" class="btn btn-primary btn-sm">글수정</button>
			<button type="button" id="boardListBtn" class="btn btn-primary btn-sm">글목록</button>
		</div>
	</div>

	<%@ include file="/WEB-INF/common/footer.jsp" %>
	<script src="/include/js/updateForm.js"></script>
</body>
</html>