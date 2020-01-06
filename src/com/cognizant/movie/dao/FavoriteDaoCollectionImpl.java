package com.cognizant.movie.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.cognizant.movie.model.Favorite;
import com.cognizant.movie.model.Movie;

public class FavoriteDaoCollectionImpl implements FavoriteDao {
    public static HashMap<Long, Favorite> userFavorite; // instance variable

    public FavoriteDaoCollectionImpl() {
        if (userFavorite == null) {
            HashMap<Long, Favorite> carts = new HashMap<Long, Favorite>();
            userFavorite = carts;
        }
    }

    @Override
    public Favorite getAllFavorites(long userId) throws FavoriteEmptyException {
        Favorite favorite = userFavorite.get(userId);
        if (favorite == null || favorite.getFavoriteList().isEmpty()) {
            throw new FavoriteEmptyException(); // break
        }
        List<Movie> movie = favorite.getFavoriteList();
        Integer total = 0;
        for (Movie movie2 : movie) {
            total = total + (int) userId;
        }
        favorite.setTotal(total);
        return favorite;

    }
  
    @Override
    public void addFavoritesById(long userId, long movieId) {
        MovieDao menuItems = new MovieDaoCollectionImpl();
        Movie movie = menuItems.getMovieById(movieId);
        if (userFavorite.containsKey(userId)) {
            userFavorite.get(userId).getFavoriteList().add(movie);
        } else {
            Favorite favorite = new Favorite();
            List<Movie> listmovie = new ArrayList<Movie>();
            listmovie.add(movie);
            favorite.setFavoriteList(listmovie);
            userFavorite.put(userId, favorite);
        }
    }

    @Override
    public void removeFavoritesById(long userId, long movieId) {
        List<Movie> list = userFavorite.get(userId).getFavoriteList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMovieId() == movieId) {
                list.remove(i);
                break;
            }
        }
    }
}
