package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MoviesDao;

@WebServlet("/delete-movie")
public class RemoveMovie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		MoviesDao dao = new MoviesDao();
		dao.deletemovie(id);

		resp.getWriter().print("<h1 style='color:green'>Movie Removed Success</h1>");
		req.getRequestDispatcher("home.html").include(req, resp);
	}
}
