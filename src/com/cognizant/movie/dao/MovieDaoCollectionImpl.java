package com.cognizant.movie.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.movie.model.Movie;
import com.cognizant.movie.util.DateUtil;

public class MovieDaoCollectionImpl implements MovieDao {
    private static List<Movie> movieList; // instance variable

    public MovieDaoCollectionImpl() {
        if (movieList == null || movieList.isEmpty()) {
            Movie title1 = new Movie(1, "Avatar", 2787965087L, true,
                    DateUtil.convertToDate("15/03/2017"), "Sciencefiction", true);
            Movie title2 = new Movie(2, "The Avengers", 1518812988L, true,
                    DateUtil.convertToDate("23/12/2017"), "Superhero", false);
            Movie title3 = new Movie(3, "Titanic", 2187463944L, true,
                    DateUtil.convertToDate("21/08/2017"), "Romance", false);
            Movie title4 = new Movie(4, "Jurassic World", 1671713208L, false,
                    DateUtil.convertToDate("02/07/2017"), "Science Fiction", true);
            Movie title5 = new Movie(5, "Avengers: End game", 2750760348L, true,
                    DateUtil.convertToDate("02/11/2022"), "Superhero", true);
            movieList = new ArrayList<Movie>();
            movieList.add(title1);
            movieList.add(title2);
            movieList.add(title3);
            movieList.add(title4);
            movieList.add(title5);
        }
    }

    @Override
    public List<Movie> getMovieListAdmin() {
        return movieList;
    }

    @Override
    public List<Movie> getMovieListCustomer() {
        ArrayList<Movie> movie = new ArrayList<Movie>();
        for (Movie movie2 : movieList) {
            if ((movie2.getDateOfLaunch().before(new Date())
                    || movie2.getDateOfLaunch().equals(new Date())) && movie2.isActive() == true) {
                movie.add(movie2);
            }
        }
        return movie;
    }

    @Override
    public Movie getMovieById(long movieId) {
        for (Movie movie : movieList) {
            if (movie.getMovieId() == movieId) // existing_id=user
                return movie;
        }
        return null; // when id is not existing, this line executes
    }

    @Override
    public void ModifyMovieList(Movie movieLists) {
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getMovieId() == movieLists.getMovieId()) { // exixting_item-id==
                movieList.set(i, movieLists);
            }
        }
    }
}
