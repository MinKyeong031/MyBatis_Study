<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>  Book 의 List</h1>
<c:forEach var='name' items='${list}'>
${name.title }, ${name.author }, ${name.price } <br/>
</c:forEach>

</body>
</html>