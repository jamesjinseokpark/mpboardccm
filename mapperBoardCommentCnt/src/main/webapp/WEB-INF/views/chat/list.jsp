<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>문의게시판</title>

<style type="text/css">
li {
	list-style: none;
	float: left;
	padding: 10px;
}
</style>
</head>
<body>
	<div id="root">
		<header>
			<h1>1:1 문의게시판</h1>
		</header>

		<hr />

		<div>
			<%@include file="nav.jsp"%>
		</div>
		<hr />



		<section id="container">
			<form method="post" action="/chat/write">
				<table>
					<tr>
						<th>게시글 번호</th>
						<th>게시글 제목</th>
						<th>게시글 작성자</th>
						<th>등록일</th>
						
					</tr>

					<c:forEach items="${list}" var="list">
						<tr>
							<td><c:out value="${list.c_no}" /></td>
							<td><a href="/chat/read?c_no=${list.c_no}"><c:out
										value="${list.c_title}" /></a></td>
							<td><c:out value="${list.w_id}" /></td>
							<td><fmt:formatDate value="${list.c_date}"
									pattern="yyyy-MM-dd" /></td>				
									
						</tr>
					</c:forEach>

				</table>

				<div>
					<ul>
						<c:if test="${pageMaker.prev}">
							<li><a
								href="list${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
						</c:if>

						<c:forEach begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}" var="idx">
							<li><a href="list${pageMaker.makeQuery(idx)}">${idx}</a></li>
						</c:forEach>

						<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
							<li><a
								href="list${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
						</c:if>
					</ul>
				</div>

			</form>
		</section>
		<hr />
	</div>
</body>
</html>