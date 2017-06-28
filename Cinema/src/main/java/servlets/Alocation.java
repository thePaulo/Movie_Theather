package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dominio.Movie;

@SuppressWarnings("serial")
@WebServlet("/aloc")
public class Alocation extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		HttpSession session = request.getSession();

		ArrayList<Movie> movies = (ArrayList<Movie>) session.getAttribute("filmes");
		
		if(movies == null){
			response.sendRedirect("http://localhost:8080/Cinema/not");
		}

		String usr = (String) session.getAttribute("login");
		out.println("<b>Hello " + usr + "<b><br>");

		ArrayList<Movie> filmes = new ArrayList<Movie>();
		for (Movie m : movies) {
			out.println(m.getNome() + "<br>");
			out.println(m.getNota() + "<br>");

			filmes.add(m);

		}
		out.println("<p><h1>Clique nos filmes para reservar um ingresso para a sessão</h1></p>");
		if (filmes.size() >= 7) {
			out.println(
					"<style>#customers {font-family:  Arial, Helvetica, sans-serif;border-collapse: collapse;width: 100%;}#customers td, #customers th {border: 1px solid #ddd;padding: 8px;}#customers tr:nth-child(even){background-color: #f2f2f2;}#customers tr:hover {background-color: #ddd;}#customers th {padding-top: 12px;padding-bottom: 12px;text-align: left;background-color: blue;color: white;}</style>");

			out.println(
					"<table id=\"customers\"><tr><th>Salas</th><th>14:10</th><th>15:20</th><th>16:30</th><th>17:40</th><th>18:50</th><th>19:00</th><th>20:10</th><th>21:20</th><th>22:30</th></tr>");
			//Sala de Filmes 1
			session.setAttribute("sala", 1);
			session.setAttribute("hora", "14:10");
							out.println("<tr><td>1</td><td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"14:10\"><input type=\"hidden\" name=\"sala\" value=\"1\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(0).getImg()+"\" /></form></td>");
													
							out.println("<td> -Em Sessao- </td>");
					session.setAttribute("hora", "16:30");
							out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"16:30\"><input type=\"hidden\" name=\"sala\" value=\"1\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(0).getImg()+"\" /></form></td>");
							
					session.setAttribute("hora", "17:40");
							out.println("</td><td> -Em Sessao- </td>");
					session.setAttribute("hora", "18:50");
							out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"18:50\"><input type=\"hidden\" name=\"sala\" value=\"1\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(0).getImg()+"\" /></form></td>");
							
					session.setAttribute("hora", "19:00");
							out.println("</td><td> -Em Sessao- </td>");
					session.setAttribute("hora", "20:10");
					out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"20:10\"><input type=\"hidden\" name=\"sala\" value=\"1\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(0).getImg()+"\" /></form></td>");
							
					session.setAttribute("hora", "21:20");
							out.println("</td><td> -Em Sessao- </td>");
					session.setAttribute("hora", "22:30");
					out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"22:30\"><input type=\"hidden\" name=\"sala\" value=\"1\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(0).getImg()+"\" /></form></td>");
							
					out.println(" </td></tr>");

			//Sala de Filmes 2
			session.setAttribute("sala", 2);
			session.setAttribute("hora", "14:10");
			out.println("<tr><td>2</td><td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"14:10\"><input type=\"hidden\" name=\"sala\" value=\"2\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(1).getImg()+"\" /></form></td>");
			
			session.setAttribute("hora", "15:20");
					out.println("</td><td> -Em Sessao- </td>");
			session.setAttribute("hora", "16:30");
							out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"16:30\"><input type=\"hidden\" name=\"sala\" value=\"2\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(1).getImg()+"\" /></form></td>");
							
			session.setAttribute("hora", "17:40");
							out.println("</td><td> -Em Sessao- </td>");
			session.setAttribute("hora", "18:50");
							out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"18:50\"><input type=\"hidden\" name=\"sala\" value=\"2\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(1).getImg()+"\" /></form></td>");
							
			session.setAttribute("hora", "19:00");
							out.println("</td><td> -Em Sessao- </td>");
			session.setAttribute("hora", "20:10");
							out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"20:10\"><input type=\"hidden\" name=\"sala\" value=\"2\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(1).getImg()+"\" /></form></td>");
							
			session.setAttribute("hora", "21:20");
							out.println("</td><td> -Em Sessao- </td>");
			session.setAttribute("hora", "22:30");
							out.println("<td> Sessão Livre </td></tr>");
			
					//Sala de Filmes 3
			session.setAttribute("sala", 3);
			session.setAttribute("hora", "14:10");
			out.println("<tr><td>3</td><td>Sessão Livre</td>");
			session.setAttribute("hora", "15:20");
					out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"15:20\"><input type=\"hidden\" name=\"sala\" value=\"3\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(2).getImg()+"\" /></form></td>");
					
			session.setAttribute("hora", "16:30");
					out.println("</td><td> -Em Sessão- </td>");
			session.setAttribute("hora", "17:40");		
					out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"17:40\"><input type=\"hidden\" name=\"sala\" value=\"3\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(2).getImg()+"\" /></form></td>");
					
			session.setAttribute("hora", "18:50");
					out.println(" </td><td>Em Sessão</td>");
			session.setAttribute("hora", "19:00");
					out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"19:00\"><input type=\"hidden\" name=\"sala\" value=\"3\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(2).getImg()+"\" /></form></td>");
					
			session.setAttribute("hora", "20:10");
					out.println("</td><td>-Em Sessão-</td>");
			session.setAttribute("hora", "21:20");		
					out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"21:20\"><input type=\"hidden\" name=\"sala\" value=\"3\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(2).getImg()+"\" /></form></td>");
					
			session.setAttribute("hora", "22:30");
					out.println(" </td><td> -Em Sessão- </td></tr>");
			
					//Sala de Filmes 4
			session.setAttribute("sala", 4);
			session.setAttribute("hora", "14:10");
					out.println("<tr><td>4</td><td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"14:10\"><input type=\"hidden\" name=\"sala\" value=\"4\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(3).getImg()+"\" /></form></td>");
					
			session.setAttribute("hora", "15:20");					
					out.println("</td><td> -Em Sessao- </td>");
			session.setAttribute("hora", "16:30");		
					out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"16:30\"><input type=\"hidden\" name=\"sala\" value=\"4\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(3).getImg()+"\" /></form></td>");
					
			session.setAttribute("hora", "17:40");
					out.println("</td><td> -Em Sessao- </td>");
			session.setAttribute("hora", "18:50");
					out.println("<td>Sessão Livre</td>");
			session.setAttribute("hora", "19:00");
					out.println("<td> Sessão Livre </td>");
			session.setAttribute("hora", "20:10");
					out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"20:10\"><input type=\"hidden\" name=\"sala\" value=\"4\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(3).getImg()+"\" /></form></td>");
					
			session.setAttribute("hora", "21:20");
					out.println("<td> -Em Sessao- </td>");
			session.setAttribute("hora", "22:30");
					out.println("<td> Sessão Livre </td></tr>");
			
					//Sala de Filmes 5
			session.setAttribute("sala", 5);
			session.setAttribute("hora", "14:10");
			out.println("<tr><td>4</td><td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"14:10\"><input type=\"hidden\" name=\"sala\" value=\"5\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(4).getImg()+"\" /></form></td>");

					out.println("</td><td> -Em Sessao- </td>");
					out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"16:30\"><input type=\"hidden\" name=\"sala\" value=\"5\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(4).getImg()+"\" /></form></td>");
							
					out.println("</td><td> -Em Sessao- </td>");
					out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"18:50\"><input type=\"hidden\" name=\"sala\" value=\"5\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(5).getImg()+"\" /></form></td>");
							
					out.println("</td><td> -Em Sessão- </td>");
							out.println("<td>Sessão Livre </td>");
							out.println("<td> Sessão Livre  </td>");
							out.println("<td> Sessão Livre </td></tr>");
			
					//Sala de Filmes 6
			session.setAttribute("sala", 6);
			
			out.println("<tr><td>6</td><td>Sessão Livre</td>");
			out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"15:20\"><input type=\"hidden\" name=\"sala\" value=\"6\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(6).getImg()+"\" /></form></td>");
					
					out.println("</td><td> -Em Sessão- </td>");
					out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"17:40\"><input type=\"hidden\" name=\"sala\" value=\"6\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(4).getImg()+"\" /></form></td>");
							
							out.println("<td>-Em Sessão-</td>");
							out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"19:00\"><input type=\"hidden\" name=\"sala\" value=\"6\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(6).getImg()+"\" /></form></td>");
							
							out.println("<td>-Em Sessão-</td>");
							out.println("<td>Sessão Livre </td>");
							out.println("<td><form action=\"kmypage\"><input type=\"hidden\" name=\"hora\" value=\"22:30\"><input type=\"hidden\" name=\"sala\" value=\"6\"><input height=\"200\" type=\"image\" type=\"submit\" src=\"" + filmes.get(5).getImg()+"\" /></form></td>");
							
			out.println("</table>");

			out.println("<p> Salas Disponíveis: 6</p>");
			out.println("<p> Sessões alocadas para <b>" + filmes.get(0).getNome() + "</b>: 5</p>");
			out.println("<p> Sessões alocadas para <b>" + filmes.get(1).getNome() + "</b>: 4</p>");
			out.println("<p> Sessões alocadas para <b>" + filmes.get(2).getNome() + "</b>: 4</p>");
			out.println("<p> Sessões alocadas para <b>" + filmes.get(3).getNome() + "</b>: 3</p>");
			out.println("<p> Sessões alocadas para <b>" + filmes.get(4).getNome() + "</b>: 3</p>");
			out.println("<p> Sessões alocadas para <b>" + filmes.get(5).getNome() + "</b>: 2</p>");
			out.println("<p> Sessões alocadas para <b>" + filmes.get(6).getNome() + "</b>: 2</p>");
		} else {
			response.sendRedirect("http://localhost:8080/Cinema/not");
		}
	}
}