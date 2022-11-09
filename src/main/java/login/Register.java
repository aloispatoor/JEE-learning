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
		
				
		if (login == null) {
			login = "";
		}

		if (password == null) {
			password = ""; 
		}
		
		if (password2 == null) {
			password2 = ""; 
		}
				
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
		
		// VERIFS
		if (login == null) {
			try (PrintWriter out = response.getWriter() ){
				out.println("Error: login can't be null");
			}
		}else if(!login.contains("@")){
			try (PrintWriter out = response.getWriter() ){
				out.println("Error: You have to tape an email");
			}
		}else if (password == null) {
			try (PrintWriter out = response.getWriter() ){
				out.println("Error: You have to tape a password");
			}
		}else if (password.length() < 9) {
			try (PrintWriter out = response.getWriter() ){
				out.println("Error: You have to tape a password with more than 8 characters");
			}
		}else if (!password.equals(password2)) {
			try (PrintWriter out = response.getWriter() ){
				out.println("Error: The password inputs aren't identical");
			}
		}else {
			try (PrintWriter out = response.getWriter() ){
				out.println("GG, you're registered! Your e-mail is " + login + " and your password is " + password + ". Keep it precisouly!");
			}
		}
		
		response.setContentType("text/html");
		doGet(request, response);
	}

}
