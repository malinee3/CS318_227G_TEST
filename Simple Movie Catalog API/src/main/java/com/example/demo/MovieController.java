package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * MovieController class for managing movie catalog API
 * Provides REST endpoints for movie operations
 */
@RestController
public class MovieController {
    
    // In-memory storage for movies
    private List<Movie> movieCatalog = new ArrayList<>();

    /**
     * GET endpoint to retrieve all movies in the catalog
     * @return List of all movies
     */
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieCatalog;
    }

    /**
     * POST endpoint to add a new movie to the catalog
     * @param title Movie title
     * @param director Movie director
     * @param releaseYear Movie release year
     * @return Success message with movie details
     */
    @PostMapping("/movies/add")
    public String addMovie(@RequestParam String title, 
                          @RequestParam String director, 
                          @RequestParam int releaseYear) {
        Movie newMovie = new Movie(title, director, releaseYear);
        movieCatalog.add(newMovie);
        return "Movie added successfully: " + newMovie.toString();
    }

    /**
     * GET endpoint to search for a movie by title
     * @param title Movie title to search for
     * @return Movie details if found, or error message if not found
     */
    @GetMapping("/movies/search")
    public Object searchMovie(@RequestParam String title) {
        Optional<Movie> foundMovie = movieCatalog.stream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(title))
                .findFirst();
        
        if (foundMovie.isPresent()) {
            return foundMovie.get();
        } else {
            return "Movie not found: " + title;
        }
    }
}
