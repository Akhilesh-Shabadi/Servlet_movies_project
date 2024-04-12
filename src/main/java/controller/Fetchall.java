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
			resp.getWriter().print("<h1 style='color:red'>No Movies Added yet</h1>");
			req.getRequestDispatcher("home.html").include(req, resp);
		} else {
//			resp.getWriter().print("<html><body><div align='center'><table border='1px'>");
//			resp.getWriter().print("<tr>");
//			resp.getWriter().print("<th>Name</th>");
//			resp.getWriter().print("<th>Language</th>");
//			resp.getWriter().print("<th>Genre</th>");
//			resp.getWriter().print("<th>Rating</th>");
//			resp.getWriter().print("<th>Image</th>");
//			resp.getWriter().print("<th>Edit</th>");
//			resp.getWriter().print("<th>Delete</th>");
//			resp.getWriter().print("</tr>");
//
//			for (Movies movie : list) {
//				resp.getWriter().print("<tr>");
//				resp.getWriter().print("<td>" + movie.getName() + "</td>");
//				resp.getWriter().print("<td>" + movie.getLanguage() + "</td>");
//				resp.getWriter().print("<td>" + movie.getGenre() + "</td>");
//				resp.getWriter().print("<td>" + movie.getRating() + "</td>");
//				resp.getWriter().print("<td>Img</td>");
//				resp.getWriter().print("<td><button>Edit</button></td>");
//				resp.getWriter().print("<td><button>Delete</button></td>");
//				resp.getWriter().print("</tr>");
//
//			}
//			resp.getWriter().print("</table></div>");
//			resp.getWriter().print("<div align='center'>");
//			resp.getWriter().print("<a href='home.html'><button>Back</button></a>");
//			resp.getWriter().print("</div></body></html>");
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("Fetchall.jsp").forward(req, resp);
		}
	}
}
