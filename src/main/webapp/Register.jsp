<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.Date"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Registration</title>
        <link rel='stylesheet' type='text/css' href='style.css' />
    </head>
    <body>
        <h1>Sign In</h1>
        <h2><%= new Date () %></h2>
        <form method="POST" action="">
            <input name="txtLogin" type="email" placeholder="login">
            <input name="txtPassword" type="password" placeholder="password">
            <input name="txtPassword2" type="password" placeholder="Repeat password">
            <input name="btnConnect" type="submit">
        </form>
        <%
            String login = request.getParameter("txtLogin");
            String password = request.getParameter("txtPassword");
            String password2 = request.getParameter("txtPassword2");
            String error = (String) request.getAttribute("error");
            
            if(login == null) login = "";
            if(password == null) password = "";
            if(password2 == null) password2 = "";
            
            if(request.getMethod().equals("POST")){
                if(login == null || login == ""){ %>
                    <p>Error: Login can't be null</p>
            <%  } else if (password == null || password == "") { %>
                    <p>Error: Password can't be null</p>
            <%  } else if (!login.contains("@")){ %>
                    <p>Error: Login have to be an email address</p>
            <%  } else if (password.length() < 9) { %>
                    <p>Error: Password must have more than 8 characters</p>
            <%  } else if (!password.equals(password2)) { %>
                    <p>Error: Both password input have to be identical</p>
            <%  } else { %>
            	<p> Welcome <%= login %>, your password is <%= password %>, keep it preciously!</p>
            <%}
        } %>
    </body>
</html>