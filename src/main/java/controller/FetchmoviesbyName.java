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

@WebServlet("/enter-name")
public class FetchmoviesbyName extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("Enter-name.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String na = req.getParameter("name");

		MoviesDao dao = new MoviesDao();

		List<Movies> list = dao.fetch(na);
		if (list.isEmpty()) {
			resp.getWriter().print("<h1 style='color:red' align='center'>No Movies Found</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		} else {
			req.setAttribute("list", list);
			req.getRequestDispatcher("Fetchall.jsp").forward(req, resp);
		}
	}
}
