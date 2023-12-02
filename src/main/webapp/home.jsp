<%@page import="com.conn.DBConnection"%>
<%@page import="javax.servlet.http.Cookie" %>
<%@page import="com.auth0.jwt.algorithms.Algorithm" %>
<%@page import="com.auth0.jwt.JWT" %>
<%@page import="com.auth0.jwt.JWTVerifier" %>
<%@page import="com.auth0.jwt.interfaces.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	String tokenValue = null;
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(Cookie ck : cookies) {
					if(ck.getName().equals("token")){
						tokenValue = ck.getValue();
					}
				}
			}
			
			if(cookies==null) {
				response.sendRedirect("index.jsp");
			}
			
			try {
				Algorithm algorithm = Algorithm.none();
				JWTVerifier verifier = JWT.require(algorithm)
						.withIssuer("auth0")
						.build();
				DecodedJWT decodedJWT = verifier.verify(tokenValue);
					
			}
			catch(Exception e) {
				e.printStackTrace();
				response.sendRedirect("logout");
			}
			
			
		%>
		
		
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Website</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    
     <%@ include file="static/custom-style.jsp"  %>
    
</head>
<body>
		
	<%@ include file="navbar.jsp" %>
	
	<%@ include file="table.jsp" %>
	
	<%@ include file="static/tailwind-script.jsp" %>
	
</body>
</html>