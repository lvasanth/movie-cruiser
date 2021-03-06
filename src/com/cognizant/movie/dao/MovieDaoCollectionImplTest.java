package com.cognizant.movie.dao;

import java.util.List;
import com.cognizant.movie.model.Movie;
import com.cognizant.movie.util.DateUtil;

public class MovieDaoCollectionImplTest {
    static MovieDao moviedao = new MovieDaoCollectionImpl();

    public static void main(String[] args) {
        testGetMovieListAdmin();
        testgetMovieListCustomer();
        testModifyMovieList();
        testGetMovieListAdmin();
        testgetMovieListCustomer();
        testGetMovieById();

    }

    public static void testGetMovieListAdmin() {
        System.out.println("Admin view");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------------------");
        MovieDao moviedao = new MovieDaoCollectionImpl();
        List<Movie> movie = moviedao.getMovieListAdmin();
        System.out.printf("%-10s%-24s%-13s%-15s%-23s%-15s%s\n", "Id", "Title", "Box Office",
                "Active", "Date Of Launch", "Genre", "Has Teaser");
        for (Movie movie2 : movie) {
            System.out.println(movie2);
        }
    }

    public static void testgetMovieListCustomer() {
        System.out.println("Customer view");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------------------");
        List<Movie> movie = moviedao.getMovieListCustomer();
        System.out.printf("%-10s%-24s%-13s%-15s%-23s%-15s%s\n", "Id", "Title", "Box Office",
                "Active", "Date Of Launch", "Genre", "Has Teaser");
        for (Movie movie2 : movie) {
            System.out.println(movie2);
        }
    }

    public static void testModifyMovieList() {
        System.out.println("Modify movie");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------------------");
        Movie movie = new Movie(1, "Frozen", 1234555555L, true,
                DateUtil.convertToDate("02/01/2018"), "Superhero", false);
        moviedao.ModifyMovieList(movie);
    }

    public static void testGetMovieById() {
        System.out.println("Get Movie List");
        System.out.println(
                "--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s%-24s%-13s%-15s%-23s%-15s%s\n", "Id", "Title", "Box Office",
                "Active", "Date Of Launch", "Genre", "Has Teaser");
        Movie movie = moviedao.getMovieById(3);
        System.out.println(movie);
    }
}
