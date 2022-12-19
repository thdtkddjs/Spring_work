<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할일 목록</title>
</head>
<body>
	<div class="container">
		<a href="insertform">할 일 추가</a>
		<h1>할일 목록</h1>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>내용</th>
					<th>날짜</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tmp" items="${list }">
					<tr>
						<th>${tmp.num }</th>
						<th>${tmp.content }</th>
						<th>${tmp.regdate }</th>
						<th><a href="updateform?num=${tmp.num }">수정</a></th>
						<th><a href="delete?num=${tmp.num }">삭제</a></th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>