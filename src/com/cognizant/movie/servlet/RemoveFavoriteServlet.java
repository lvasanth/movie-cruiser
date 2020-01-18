package com.cognizant.movie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.FavoriteDao;
import com.cognizant.movie.dao.FavoriteDaoCollectionImpl;
import com.cognizant.movie.dao.FavoriteEmptyException;
import com.cognizant.movie.model.Favorite;
import com.cognizant.movie.model.Movie;

/**
 * Servlet implementation class RemoveFavoriteServlet
 */
@WebServlet("/RemoveFavorite")
public class RemoveFavoriteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            long userId = 1;
            long movieId = Long.parseLong(request.getParameter("movieId"));
            FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();
            favoriteDao.removeFavoritesById(userId, movieId);
            Favorite favorite = favoriteDao.getAllFavorites(userId);
            List<Movie> movieList = favorite.getFavoriteList();
            int total = 0;

            for (Movie movie : movieList) {
                total = (int) (total + userId);

            }

            favorite.setTotal(total);
            request.setAttribute("movie", movieList);// carry all the items to cart
            request.setAttribute("favorite", favorite);
            request.setAttribute("removeFavoriteStatus", true);
            request.getRequestDispatcher("favorites.jsp").forward(request, response);
        } catch (FavoriteEmptyException e) {
            request.getRequestDispatcher("favorites-empty.jsp").forward(request, response);
        }

    }

}
