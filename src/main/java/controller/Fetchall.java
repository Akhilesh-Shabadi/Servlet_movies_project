package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoviesDao;
import dto.Movies;

@WebServlet("/fetchall")
public class Fetchall extends HttpServlet {
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.getWriter().print("<h1>List of Movies</h1>");
//
//		MoviesDao dao = new MoviesDao();
//		resp.getWriter().println(dao.fetchall());
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MoviesDao dao = new MoviesDao();
		List<Movies> list = dao.fetchall();
		if (list.isEmpty()) {
			resp.getWriter().print("<h1>No Movies Added yet</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		} else {
			resp.getWriter().print("<html><body><div align='center'><table>");
			resp.getWriter().print("<tr>");
			
			resp.getWriter().print("</tr>");
			resp.getWriter().print("</table></div></body></html>");
		}
	}
}
