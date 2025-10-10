package com.example.demo;

/**
 * Movie class representing a movie in the catalog
 * Contains private properties with public getters only
 */
public class Movie {
    private String title;
    private String director;
    private int releaseYear;

    /**
     * Constructor for Movie object
     * @param title Movie title
     * @param director Movie director
     * @param releaseYear Movie release year
     */
    public Movie(String title, String director, int releaseYear) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    /**
     * Get movie title
     * @return movie title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get movie director
     * @return movie director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Get movie release year
     * @return movie release year
     */
    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }
}
