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
		<form action="update" method="post">
			<h1>일 정보 수정</h1>
			<input type="hidden" name="num" value="${dto.num }" />
			<div>
				<label for="num">번호</label>
				<input type="text" id="num" value="${dto.num }" />
			</div>
			<div>
				<label for="content">내용</label>
				<input type="text" name="content" value="${dto.content }" />
			</div>
			<div>
				<label for="regdate">날짜</label>
				<input type="text" name="regdate" value="${dto.regdate }" />
			</div>
			<button type="submit">변경하기</button>
			<button type="reset">리셋</button>
		</form>
	</div>
</body>
</html>