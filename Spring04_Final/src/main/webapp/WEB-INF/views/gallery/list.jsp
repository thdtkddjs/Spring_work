<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/file/list.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<style>
	#sampleImage{
	      width: 50px;
	      height: 50px;
	      border: 1px solid #cecece;
	      border-radius: 50%;
	}
</style>
</head>
<body>
   <div class="container">
      <a href="${pageContext.request.contextPath }/gallery/insertform">그림 추가하기</a>
      <h3>갤러리</h3>
      <table class="table table-striped">
         <thead class="table-dark">
            <tr>
               <th>번호</th>
               <th>작성자</th>
               <th>설명</th>
               <th>이미지</th>
               <th>등록일</th>
            </tr>
         </thead>
         <tbody>
         <c:forEach var="tmp" items="${list }">
            <tr>
               <td>${tmp.num }</td>
               <td>${tmp.writer }</td>
               <td><a href="${pageContext.request.contextPath}/gallery/detail?num=${tmp.num }">${tmp.caption }</a></td>
               <td><img id="sampleImage" src="${pageContext.request.contextPath}${tmp.imagePath}" alt="${tmp.caption }" /></td>
               <td>${tmp.regdate }</td>
            </tr>
         </c:forEach>
         </tbody>
      </table>
   </div>
</body>
</html>