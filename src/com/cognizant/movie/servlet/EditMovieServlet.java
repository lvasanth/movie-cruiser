package com.cognizant.movie.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.MovieDao;
import com.cognizant.movie.dao.MovieDaoCollectionImpl;
import com.cognizant.movie.model.Movie;
import com.cognizant.movie.util.DateUtil;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/EditMovie")
public class EditMovieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("title");
        long boxOffice = Long.parseLong(request.getParameter("boxOffice"));
        String isactive = request.getParameter("active");
        String dateOfLaunch = request.getParameter("dateOfLaunch");
        String genre = request.getParameter("genre");
        String isfreeDelivery = request.getParameter("freeDelivery");
        boolean active = false;
        boolean freeDelivery = false;
        if (isactive.equals("No")) {
            active = false;
        } else {
            active = true;
        }
        if (isfreeDelivery == null) {
            freeDelivery = false;
        } else {
            freeDelivery = true;
        }

        Movie movie = new Movie(id, name, boxOffice, active, DateUtil.convertToDate(dateOfLaunch),
                genre, freeDelivery);
        MovieDao movieDao = new MovieDaoCollectionImpl();
        movieDao.ModifyMovieList(movie);
        request.getRequestDispatcher("edit-movie-status.jsp").forward(request, response);
    }
}
