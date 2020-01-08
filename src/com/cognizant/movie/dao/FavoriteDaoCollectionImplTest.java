package com.cognizant.movie.dao;

import java.util.List;

import com.cognizant.movie.model.Movie;

public class FavoriteDaoCollectionImplTest {
    static FavoriteDao favoriteDao = new FavoriteDaoCollectionImpl();

    public static void main(String[] args) {

        testAddFavorites();
        testgetAllFavorites();
        testRemoveFavorites();
        testgetAllFavorites();

    }

    public static void testAddFavorites() {
        System.out.println("Add favorites to list ");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------------------");
        favoriteDao.addFavoritesById(1, 2);
        favoriteDao.addFavoritesById(1, 3);
        favoriteDao.addFavoritesById(1, 4);
        favoriteDao.addFavoritesById(1, 5);
    }

    public static void testRemoveFavorites() {
        System.out.println("Remove Favorites ");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------------------");

        favoriteDao.removeFavoritesById(1, 3);
        favoriteDao.removeFavoritesById(1, 5);
    }

    public static void testgetAllFavorites() {
        try {
            System.out.println("Retrieving  Favorites");
            System.out.println(
                    "--------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s%-22s%-15s%-15s%-23s%-15s%s\n", "Id", "Title", "Box Office",
                    "Active", "Date Of Launch", "Genre", "Has Teaser");
            List<Movie> list = favoriteDao.getAllFavorites(1).getFavoriteList();
            for (Movie movie : list) {
                System.out.println(movie);
            }
            System.out.println("No of favorites: " + favoriteDao.getAllFavorites(1).getTotal());
        } catch (FavoriteEmptyException e) {
            System.out.println(e);
        }
    }
}
