<%@page import="com.conn.DBConnection"%>
<%@page import="javax.servlet.http.Cookie" %>
<%@page import="com.auth0.jwt.algorithms.Algorithm" %>
<%@page import="com.auth0.jwt.JWT" %>
<%@page import="com.auth0.jwt.JWTVerifier" %>
<%@page import="com.auth0.jwt.interfaces.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<%@include file="verifyAuth.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <%@ include file="static/custom-style.jsp"  %>
</head>

<body>
	
	<%@ include file="navbar.jsp" %>
  	<%@ include file="BookForm.jsp" %>
  	<%@ include file="static/tailwind-script.jsp" %>
</body>

</html>