// ============================================================
//  MovieRepository.java  —  Spring Data JPA Repository
//  Place this file at:
//  src/main/java/com/cinemaebooking/repository/MovieRepository.java
// ============================================================

package com.cinemaebooking.repository;

import com.cinemaebooking.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // Find all movies by status ("now-playing" or "coming-soon")
    List<Movie> findByStatus(String status);

    // Search movies by title (case-insensitive, partial match)
    List<Movie> findByTitleContainingIgnoreCase(String title);

    // Filter by genre
    List<Movie> findByGenreIgnoreCase(String genre);
}