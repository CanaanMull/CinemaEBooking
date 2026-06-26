// ============================================================
//  MovieController.java  —  REST Controller
//  Place this file at:
//  src/main/java/com/cinemaebooking/controller/MovieController.java
// ============================================================

package com.cinemaebooking.controller;

import com.cinemaebooking.model.Movie;
import com.cinemaebooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    // GET /api/movies  →  all movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // GET /api/movies/{id}  →  single movie by ID  ← NEW for details page
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return movieRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET /api/movies/now-playing
    @GetMapping("/now-playing")
    public List<Movie> getNowPlaying() {
        return movieRepository.findByStatus("now-playing");
    }

    // GET /api/movies/coming-soon
    @GetMapping("/coming-soon")
    public List<Movie> getComingSoon() {
        return movieRepository.findByStatus("coming-soon");
    }

    // GET /api/movies/search?title=dune
    @GetMapping("/search")
    public List<Movie> searchByTitle(@RequestParam String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    // GET /api/movies/filter?genre=action
    @GetMapping("/filter")
    public List<Movie> filterByGenre(@RequestParam String genre) {
        return movieRepository.findByGenreIgnoreCase(genre);
    }
}