<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sign In</title>
		<link rel='stylesheet' type='text/css' href='style.css' />
	</head>
	<body>
		
		<h1>Sign In</h1>
		<p>${error}</p>
        <form method="POST" action="signin">
            <input name="txtLogin" type="email" value="${login}" placeholder="login">
            <input name="txtPassword" type="password" value="${password}" placeholder="password">
            <input name="txtPassword2" type="password" value="${password2}" placeholder="Repeat password">
            <input name="btnConnect" type="submit">
        </form>
	</body>
</html>