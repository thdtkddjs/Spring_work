<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>
	<div class="container">
		<c:choose>
			<c:when test="${empty sessionScope.id }">
				<a href="${pageContext.request.contextPath}/users/loginform">로그인</a>
				<a href="users/signup_form">회원 가입</a>
			</c:when>
			<c:otherwise>
				<p>
					<a href="${pageContext.request.contextPath}/users/info">${sessionScope.id }</a>로그인 됨
					<a href="${pageContext.request.contextPath}/users/logout">로그아웃</a>
				</p>
			</c:otherwise>
		</c:choose>
		<h1>인덱스 페이지입니다.</h1>
		<ul>
			<li><a href="get_msg">@ResponseBody 어노테이션 테스트</a></li>
			<li><a href="get_person">한 명의 정보</a></li>
			<li><a href="get_user">한 회원의 정보</a></li>
			<li><a href="get_friends">친구목록</a></li>
			<li><a href="get_users">회원목록</a></li>
			<li><a href="file/list">자료실</a></li>
			<li><a href="cafe/list">카페로 가기</a></li>
			<li><a href="shop/list">과일사러 가기</a></li>
			<li><a href="gallery/list">갤러리 목록보기</a></li>
		</ul>
		<h3>공지사항</h3>
		<ul>
			<c:forEach var="tmp" items="${noticeList}">
				<li>${tmp}</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>