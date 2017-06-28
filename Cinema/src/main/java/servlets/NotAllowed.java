package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/not")
public class NotAllowed extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();		
		response.setContentType("text/html");
		
		out.println("You Were Not Allowed To Enter That Page");
		out.println("<br>Probably You have less than 7 movies in your movie theater");
		//HttpSession session = request.getSession();
		//ArrayList<Movie> movies = (ArrayList<Movie>) session.getAttribute("filmes");
		
		//String usr = (String) session.getAttribute("login");
		
	}
}