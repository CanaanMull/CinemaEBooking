package com.cinemaebooking.config;

import com.cinemaebooking.model.Movie;
import com.cinemaebooking.model.Showtime;
import com.cinemaebooking.repository.MovieRepository;
import com.cinemaebooking.repository.ShowtimeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class ShowtimeSeeder implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final ShowtimeRepository showtimeRepository;

    public ShowtimeSeeder(MovieRepository movieRepository, ShowtimeRepository showtimeRepository) {
        this.movieRepository = movieRepository;
        this.showtimeRepository = showtimeRepository;
    }

    @Override
    public void run(String... args) {
        // Regenerate fresh each startup (dates shift forward each day)
        showtimeRepository.deleteAll();

        List<Movie> nowPlaying = movieRepository.findByStatus("now-playing");
        List<String> timePool = Arrays.asList(
            "11:00", "13:00", "14:30", "16:00", "17:30", "19:00", "20:30", "22:00"
        );
        Random rnd = new Random();
        LocalDate today = LocalDate.now();
        List<Showtime> batch = new ArrayList<>();

        // Today + the next 6 days
        for (int d = 0; d < 7; d++) {
            String date = today.plusDays(d).toString();   // ISO yyyy-MM-dd
            for (Movie m : nowPlaying) {
                List<String> times = new ArrayList<>(timePool);
                Collections.shuffle(times, rnd);
                int count = 3 + rnd.nextInt(2);            // 3 or 4 showings
                times = new ArrayList<>(times.subList(0, count));
                Collections.sort(times);                  // chronological
                for (String t : times) {
                    batch.add(new Showtime(m.getId(), date, t, "Screen " + (1 + rnd.nextInt(6))));
                }
            }
        }
        showtimeRepository.saveAll(batch);
        System.out.println("Seeded " + batch.size() + " showtimes across 7 days.");
    }
}