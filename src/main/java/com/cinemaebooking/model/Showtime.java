package com.cinemaebooking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "showtimes")
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_id", nullable = false)
    private Long movieId;

    @Column(name = "show_date", nullable = false)
    private String showDate;   // yyyy-MM-dd

    @Column(name = "show_time", nullable = false)
    private String showTime;   // 24-hour HH:mm

    private String auditorium;

    public Showtime() {}

    public Showtime(Long movieId, String showDate, String showTime, String auditorium) {
        this.movieId = movieId;
        this.showDate = showDate;
        this.showTime = showTime;
        this.auditorium = auditorium;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getMovieId() { return movieId; }
    public void setMovieId(Long movieId) { this.movieId = movieId; }
    public String getShowDate() { return showDate; }
    public void setShowDate(String showDate) { this.showDate = showDate; }
    public String getShowTime() { return showTime; }
    public void setShowTime(String showTime) { this.showTime = showTime; }
    public String getAuditorium() { return auditorium; }
    public void setAuditorium(String auditorium) { this.auditorium = auditorium; }
}