package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try (PrintWriter out = response.getWriter() ){
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("	<head>");
			out.println("	</head>");
			out.println("	<body>");
			out.println("		<h1>Veuillez vous identifier</h1>");
			out.println("		<h2>" + new Date() + "</h2>");
			out.println("		<form method='POST'>");
			out.println("			<input name='txtLogin' type='text' placeholder='login'>");
			out.println("			<input name='txtPAssword' type='password'>");
			out.println("			<input name='btnConnect' type='submit'>");
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
		
		doGet(request, response);
	}

}
