package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// VARIABLES
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		String password2 = request.getParameter("txtPassword2");
		String error = (String) request.getAttribute("error");
				
		if (login == null) login = "";
		if (password == null) password = ""; 
		if (password2 == null) password2 = ""; 
				
		System.out.println(login + " - " + password + " - " + password2);
		
		response.setContentType("text/html");
		
		
		//BIZARRE
		try (PrintWriter out = response.getWriter() ){
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("	<head>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("		<h1>Veuillez vous inscrire</h1>");
			out.println("		<h2>" + new Date() + "</h2>");
			if(error != null) {
				out.println("		<p>" + error + "</p>");
			} else {
				System.out.println("Error null");
			}
			out.println("		<form method='POST'>");
			out.println("			<input name='txtLogin' type='email' placeholder='login'>");
			out.println("			<input name='txtPassword' type='password' placeholder='password'>");
			out.println("			<input name='txtPassword2' type='password' placeholder='repeat password'>");
			out.println("			<input name='btnRegister' type='submit'>");
			out.println("		<form method='POST'>");
			out.println("		</form>");
			out.println("	</body>");
			out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		String password2 = request.getParameter("txtPassword2");
		
		response.setContentType("text/html");
		
		// VERIFS
		if (login == null || login == "") {
			request.setAttribute("error", "Login can't be null");
			doGet(request, response);
		}else if(!login.contains("@")){
			request.setAttribute("error", "Login have to be an email");
			doGet(request, response);
		}else if (password == null || password == "") {
			request.setAttribute("error", "Password can't be null");
			doGet(request, response);
		}else if (password.length() < 9) {
			request.setAttribute("error", "Password must have more than 8 character");
			doGet(request, response);
		}else if (!password.equals(password2)) {
			request.setAttribute("error", "Passwords aren't indentical");
			doGet(request, response);
		}else {
			try (PrintWriter out = response.getWriter() ){
				out.println("GG, you're registered! Your e-mail is " + login + " and your password is " + password + ". Keep it precisouly!");
				doGet(request, response);
			}
		}
		
		
	}

}
