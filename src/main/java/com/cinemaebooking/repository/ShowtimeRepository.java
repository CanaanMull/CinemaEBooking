package com.cinemaebooking.repository;

import com.cinemaebooking.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

    List<Showtime> findByShowDateOrderByShowTime(String showDate);

    List<Showtime> findByMovieIdAndShowDateOrderByShowTime(Long movieId, String showDate);

    @Query("SELECT DISTINCT s.showDate FROM Showtime s ORDER BY s.showDate")
    List<String> findDistinctDates();
}