

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
				return;
			}
			
			try {
				Algorithm algorithm = Algorithm.none();
				JWTVerifier verifier = JWT.require(algorithm)
						.withIssuer("auth0")
						.build();
				DecodedJWT decodedJWT = verifier.verify(tokenValue);
				response.sendRedirect("home.jsp");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
		%>