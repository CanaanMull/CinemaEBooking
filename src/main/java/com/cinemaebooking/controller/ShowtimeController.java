package com.cinemaebooking.controller;

import com.cinemaebooking.model.Movie;
import com.cinemaebooking.model.Showtime;
import com.cinemaebooking.repository.MovieRepository;
import com.cinemaebooking.repository.ShowtimeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/showtimes")
@CrossOrigin(origins = "*")
public class ShowtimeController {

    private final ShowtimeRepository showtimeRepository;
    private final MovieRepository movieRepository;

    public ShowtimeController(ShowtimeRepository showtimeRepository, MovieRepository movieRepository) {
        this.showtimeRepository = showtimeRepository;
        this.movieRepository = movieRepository;
    }

    // The shape the homepage consumes: each movie playing on a date + its times
    public record MovieWithTimes(Movie movie, List<String> times) {}

    // GET /api/showtimes/movies?date=2026-06-30
    @GetMapping("/movies")
    public List<MovieWithTimes> moviesByDate(@RequestParam String date) {
        List<Showtime> showtimes = showtimeRepository.findByShowDateOrderByShowTime(date);

        // Group times by movie, preserving the (already sorted) order
        Map<Long, List<String>> timesByMovie = new LinkedHashMap<>();
        for (Showtime s : showtimes) {
            timesByMovie.computeIfAbsent(s.getMovieId(), k -> new ArrayList<>()).add(s.getShowTime());
        }

        List<MovieWithTimes> result = new ArrayList<>();
        for (Map.Entry<Long, List<String>> entry : timesByMovie.entrySet()) {
            movieRepository.findById(entry.getKey())
                .ifPresent(movie -> result.add(new MovieWithTimes(movie, entry.getValue())));
        }
        return result;
    }

    // GET /api/showtimes?date=2026-06-30   (raw list)
    @GetMapping
    public List<Showtime> byDate(@RequestParam String date) {
        return showtimeRepository.findByShowDateOrderByShowTime(date);
    }

    // GET /api/showtimes/dates   (all dates that have showings)
    @GetMapping("/dates")
    public List<String> availableDates() {
        return showtimeRepository.findDistinctDates();
    }

    // GET /api/showtimes/movie/5?date=2026-06-30   (handy for the detail page later)
    @GetMapping("/movie/{id}")
    public List<Showtime> byMovieAndDate(@PathVariable Long id, @RequestParam String date) {
        return showtimeRepository.findByMovieIdAndShowDateOrderByShowTime(id, date);
    }
}