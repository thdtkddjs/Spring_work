<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<form action="insert">
		<div>
			<label for="content">내용</label>
			<input type="text" name="content" />
		</div>
		<div>
			<label for="regdate">날짜</label>
			<input type="text" name="regdate" />
		</div>
		<button type="submit">추가하기</button>
	</form>
	</div>
</body>
</html>