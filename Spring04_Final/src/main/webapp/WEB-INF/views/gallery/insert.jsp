<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/gallery/insert</title>
</head>
<body>
	<h3>알림</h3>
	<p>
		<strong>${dto.writer }</strong>님이 사진을 등록하셨습니다.
		<a href="${pageContext.request.contextPath}/gallery/list">확인</a>
	</p>
</body>
</html>