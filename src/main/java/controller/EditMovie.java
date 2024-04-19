package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.MoviesDao;
import dto.Movies;

@WebServlet("/updating-movie")
@MultipartConfig
public class EditMovie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("obj"));
		MoviesDao dao = new MoviesDao();
		Movies list = dao.findmovie(num);
		req.setAttribute("list", list);
		req.getRequestDispatcher("Edit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int num = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String lang = req.getParameter("language");
		String genre = req.getParameter("genre");
		Part image = req.getPart("image");
		double rating = 0.0d;

		MoviesDao dao = new MoviesDao();

		try {
			rating = Double.parseDouble(req.getParameter("rating"));
		} catch (NumberFormatException e) {
			resp.getWriter().print("<h1 style='color:red'>Enter correct rating</h1>");
			req.getRequestDispatcher("Edit.jsp").include(req, resp);
		}

		Movies movies = dao.findmovie(num);

		byte[] pic = new byte[image.getInputStream().available()];
		image.getInputStream().read(pic);

		if (pic.length > 0)
			movies.setImg(pic);

		movies.setName(name);
		movies.setRating(rating);
		movies.setLanguage(lang);
		movies.setGenre(genre);

		dao.updatemovie(movies);

		resp.getWriter().print("<h1 style='color:green'>Updated successfully</h1>");
		req.getRequestDispatcher("home.html").include(req, resp);
	}
}
