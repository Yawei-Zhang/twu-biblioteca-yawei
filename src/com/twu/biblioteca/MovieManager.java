package com.twu.biblioteca;

import com.twu.biblioteca.models.Movie;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MovieManager {

    private ArrayList<Movie> movieList;

    public MovieManager() {
        movieList = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    public ArrayList<Movie> getAvailableMovie() {
        return (ArrayList<Movie>) this.movieList.stream()
                .filter(movie -> movie.isAvailable())
                .collect(Collectors.toList());
    }

    public void listAllMovies() {
        Printer.print("Name\tYear\tDirector\tRating");
        Printer.print(this.getAvailableMovie());
    }
}
