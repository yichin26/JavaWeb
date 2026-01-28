<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>
<c:catch var="err">
<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/iii"
		user="root"
		password="root"
	/>
	<sql:update var="num">
			UPDATE cust
			SET tel = ?
			WHERE id = ?
			<sql:param>77777</sql:param>		
			<sql:param>35</sql:param>		
		</sql:update>
		
</c:catch>
<c:if test="${!empty err }"><${err }</c:if>
<c:choose>
	<c:when test="${!empty err }"><${err }"></c:when>
	<c:when test="${num > 0 }">success</c:when>
	<c:otherwise>Failure</c:otherwise>
</c:choose>
update:${num}<br>