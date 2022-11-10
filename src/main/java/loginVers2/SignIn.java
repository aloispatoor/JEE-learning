package loginVers2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "signin", urlPatterns = { "/signin" })
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		String password2 = request.getParameter("txtPassword2");
		
		if(login == null) login = "";
		if(password == null) password = "";
		if(password2 == null) password2 = "";
		
		String error = "";
		
		if(login == null || login == "") {
			error = "Error: Login can't be null";
		} else if (password == null || password == "") {
			error = "Error: password can't be null";
		} else if (!login.contains("@")) {
			error = "Error: Login must be an email";
		} else if (!password.equals(password2)) {
			error = "Error: Password fields aren't identical";
		} else if (password.length() < 9) {
			error = "Error: Password must have more than 8 characters";	
		} else {
			request.getRequestDispatcher("/Registered.jsp").forward(request, response);
		}
		
		if(error != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("error", error);
			doGet(request, response);
		}
		
		
	}

}
