<%@page import="com.conn.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="static/bootstrap.jsp" %>

</head>
<body>
	<div>
		<%
			DBConnection.connect();
		%>
	</div>
	<%@ include file="navbar.html" %>
	
	<%@ include file="table.jsp" %>
	
</body>
</html>