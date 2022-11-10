<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Log In Page</title>
	<link rel='stylesheet' type='text/css' href='style.css' />
</head>
<body>
	<h1>Log in</h1>
	<h2><%= new Date () %></h2>
	<%
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		
		if(login == null) login = "";
		if(password == null) password = "";
		
		if(request.getMethod().equals("POST" && login.equals("java") && password.equals("jee")){%>
	<p>Welcome XXX</p>
	<% } else { %>
	<form method="POST" action="">
		<input name="txtLogin" type="email" value="" placeholder="login">
		<input name="txtPassword" type="password" placeholder="password">
		<input name="btnConnect" type="submit">
	</form>
	<%}%>
</body>
</html>