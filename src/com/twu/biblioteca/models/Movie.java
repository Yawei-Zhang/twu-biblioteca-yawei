package com.twu.biblioteca.models;

public class Movie {
    private String name;
    private String year;
    private String director;
    private String rating;
    private boolean isAvailable;

    public Movie(String name, String year, String director, String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.isAvailable = true;
    }

    public void handleCheckout() {
        this.isAvailable = false;
    }

    public void handleReturn() {
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return this.name + ",\t" + this.year + ",\t" + this.year + ",\t" + this.rating;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;

        if (!(object instanceof Movie))
            return false;

        Movie movie = (Movie) object;

        return movie.getName() == this.name &&
                movie.getYear() == this.year &&
                movie.getDirector() == this.director &&
                movie.getRating() == this.rating;
    }

    public boolean isAvailable( ) {
        return this.isAvailable;
    }

    public String getName() {
        return this.name;
    }

    public String getYear() {
        return this.year;
    }

    public String getDirector() {
        return this.director;
    }

    public String getRating() {
        return this.rating;
    }
}
