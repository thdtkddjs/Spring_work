<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/gallery/detail.jsp</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>

</head>
<body>
   <div class="container">
      <h3>이미지 상세 보기</h3>
      <table>
         <tr>
            <th>글번호</th>
            <td>${dto.num }</td>
         </tr>
         <tr>
            <th>작성자</th>
            <td>${dto.writer }</td>
         </tr>
         <tr>
            <th>설명</th>
            <td>${dto.caption }</td>
         </tr>
         <tr>
            <td colspan="2">
               <img src="${pageContext.request.contextPath}${dto.imagePath}" alt="${dto.caption }" />
            </td>
         </tr>   
      </table>
      <c:if test="${sessionScope.id eq dto.writer }">
         <a href="updateform?num=${dto.num }">수정</a>
         <a href="javascript:" onclick="deleteConfirm()">삭제</a>
         <script>
            function deleteConfirm(){
               const isDelete=confirm("이 글을 삭제 하겠습니까?");
               if(isDelete){
                  location.href="delete?num=${dto.num}";
               }
            }
         </script>
      </c:if>
</body>
</html>