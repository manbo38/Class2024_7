<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach 태그</title>
</head>
<body>

<h3>int형 배열</h3>
<c:set var="intArray" value="<%= new int[] {1,2,3,4,5} %>" />

<c:forEach var="i" items="${intArray}">
    ${i}
</c:forEach>

<% 
	String[] str = {"java","jsp","웹표준","spring","python"};
	request.setAttribute("subject", str);

%>
<c:forEach var="s" items="${subject}">
	${s}<br>
</c:forEach>

</body>
</html>