<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Log in to Hello app</title>
	<link rel='stylesheet' type='text/css' href='style.css' />
	</head>
	<body>
		<h1>Log in</h1>
		<form method="POST" action="loginVers2">
			<input name="txtLogin" type="email" value="<%= session.getAttribute("login") %>" placeholder="login">
			<input name="txtPassword" type="password" value="${password}" placeholder="password">
			<input name="btnConnect" type="submit">
		</form>
	</body>
</html>