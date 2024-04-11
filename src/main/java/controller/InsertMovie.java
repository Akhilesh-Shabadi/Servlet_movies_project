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

@WebServlet("/insert-movie")
@MultipartConfig
public class InsertMovie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("insert.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String name = req.getParameter("moviename");
			String lang = req.getParameter("language");
			Part image = req.getPart("image");
			String genre = req.getParameter("genre");
			double rating = Double.parseDouble(req.getParameter("rating"));
//			resp.getWriter().print(name + " " + lang + " " + rating + " " + image + " " + genre);
			
			Movies movies=new Movies();
			movies.setName(name);
			movies.setLanguage(lang);
			movies.setGenre(genre);
			movies.setRating(rating);
			
			byte[] pic=new byte[image.getInputStream().available()];
			image.getInputStream().read(pic);
			movies.setImg(pic);
			
			MoviesDao dao=new MoviesDao();
			dao.saveMovie(movies);
			
			resp.getWriter().print("<h1 style='color:green'> Movie added to Database</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
			
			
		} catch (NumberFormatException e) {
			resp.getWriter().print("<h1>Enter correct rating</h1>");
			req.getRequestDispatcher("insert.html").include(req, resp);
		}
	}
}
