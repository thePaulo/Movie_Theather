package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.IngressoMB;


@SuppressWarnings("serial")
@WebServlet("/kmypage")
public class RedirectServlet extends HttpServlet {
	@Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		
		
		HttpSession session = request.getSession();
		String str = (String)session.getAttribute("hora");
		PrintWriter out = response.getWriter();
		out.println(str);
		
		String hora = (String)request.getParameter("hora");
		String sala = (String)request.getParameter("sala");
		
		out.println("Redirecting...");
		
		session.setAttribute("hora", hora);
		session.setAttribute("sala", sala);
		
		response.sendRedirect("pay.jsf");
		
		//IngressoMB ing = new IngressoMB();
		//ing.cadastrar();
		
	}
}