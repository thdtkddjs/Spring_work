<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/file/delete.jsp</title>
</head>
<body>
<div class="container">
	<h3>Alert</h3>
	<p>
		<strong>${requestScope.num }</strong> 번 자료가 삭제되었습니다.
		<a href="${pageContext.request.contextPath}/file/list">확인</a>
	</p>
</div>
</body>
</html>