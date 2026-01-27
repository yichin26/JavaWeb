<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.tina.apis.*"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<c:set var="score">${Utils.createScore() }</c:set> 
	Score:${score }<br>
	<c:if test="${score>=60}">pass</c:if>
	<c:if test="${score<60}">fail</c:if>
	<hr>
	<c:choose>
		<c:when test="${score >=90 }">A</c:when>
		<c:when test="${score >=80 }">B</c:when>
		<c:when test="${score >=70 }">C</c:when>
		<c:when test="${score >=60 }">D</c:when>
		<c:otherwise>E</c:otherwise>
	</c:choose>
		
	</body>
</html>