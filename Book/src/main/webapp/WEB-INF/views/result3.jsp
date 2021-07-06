<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML5>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="css/login.css">
  </head>

  <body width="100%" height="100%">
    <form action="/update" method="post" class="loginForm">
      <h2>Login</h2>
      <div class="idForm">Title
        <input type="text" name="title" value="${dto.title }" placeholder="ID">
      </div>
      <div class="idForm">Author
        <input type="text" name="author" value="${dto.author}" placeholder="ID">
      </div>
      <div class="idForm">Price
        <input type="text" name="price" value="${dto.price}" placeholder="ID">
      </div>
      <button type="submit" class="btn" >
        LOG IN
      </button>
      
    </form>
  </body>
</html>