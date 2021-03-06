package com.twu.biblioteca;

import com.twu.biblioteca.models.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MovieManagerTest {

    private MovieManager movieManager;

    @Before
    public void init() {
        movieManager = new MovieManager();
        movieManager.addMovie(new Movie("Coco", "2017", "Lee Unkrich", "9.0"));
        movieManager.addMovie(new Movie("The Avengers", "2012", "Joss Whedon", "8.1"));
    }

    @Test
    public void should_not_show_the_movie_when_checkout_the_movie() {
        ArrayList<Movie> expectMovieList = new ArrayList<>();
        expectMovieList.add(new Movie("Coco", "2017", "Lee Unkrich", "9.0"));
        assertTrue(movieManager.checkoutMovie("The Avengers"));
        assertEquals(expectMovieList, movieManager.getAvailableMovie());
    }
}