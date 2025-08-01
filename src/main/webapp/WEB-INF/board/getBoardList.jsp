<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/common/header.jsp" %>

<body>
	<div class="container">
		<div class="text-center"><h3>게시판 리스트</h3></div>
			<%-- post 방식으로 전송 시 form 태그 정의. --%>
			<form name="detailForm" id="detailForm">
				<input type="hidden" name="num" id="num" />
			</form>	
		<form id="f_search" name="f_search" >
			<div class="row g-2 align-items-center">
				<div class="col-auto">
					<label for="search">검색조건</label>
				</div>
				<div class="col-auto">
					<select id="search" name="search" class="form-select form-select-sm">
						<option value="all">전체조회</option>
						<option value="title">제목</option>
						<option value="author">작성자</option>
					</select>
				</div>
				<div class="col-auto">
					<input type="text" name="keyword" id="keyword" class="form-control form-control-sm" />
				</div>
				<div class="col-auto">
					<button type="button" id="searchData" class="btn btn-primary btn-sm">검색</button>
				</div>
			</div>
		</form>
		<div id="boardList">
			<table summary="게시판 리스트" class="table">
				<thead>
					<tr class="text-center">
						<th class="col-md-1">번호</th>
						<th class="col-md-6">제목</th>
						<th class="col-md-2">작성자</th>
						<th class="col-md-2">날짜</th>
						<th class="col-md-1">조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${ not empty list }">
							<c:forEach var="board" items="${ list }">
								<tr class="text-center" data-num="${ board.num }">
									<td>${ board.num }</td>
									<td class="text-start">
										<span class="goDetail">${ board.title }</span>
										<%-- <a href="/board/detailBoard.do?num=${ board.num }">${ board.title }</a> --%>
									</td>
									<td>${ board.author }</td>
									<td>${ board.writeday }</td>
									<td>${ board.readcnt }</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="5" class="text-center">등록된 게시물이 존재하지 않습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		
		<div class="contentBtn text-end">
			<button type="button" id="writeForm" class="btn btn-primary btn-sm">글작성</button>
		</div>
	</div>
	<%@ include file="/WEB-INF/common/footer.jsp" %>
	<script src="/include/js/getBoardList.js"></script>
	<script>
		// 검색 후 검색 대상과 검색 단어 출럭 - 검색여부는 키워드(keyword)의 값 존재여부로 제어
		if('${ param.keyword }' != "") {
			$("#keyword").val('${ param.keyword }');
			$("#search").val('${ param.search }');
		}
	</script>
</body>
</html>