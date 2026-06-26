// ============================================================
//  Movie.java  —  JPA Entity
//  Place this file at:
//  src/main/java/com/cinemaebooking/model/Movie.java
// ============================================================

package com.cinemaebooking.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String rating;       // MPAA rating

    private String runtime;
    private String synopsis;
    private String director;
    private String cast;

    @Column(name = "trailer_url")
    private String trailerUrl;

    @Column(name = "poster_url")
    private String posterUrl;

    private int stars;

    @Column(nullable = false)
    private String status;       // "now-playing" or "coming-soon"

    // ── Getters & Setters ────────────────────────────────────

    public Long getId()                  { return id; }
    public void setId(Long id)           { this.id = id; }

    public String getTitle()             { return title; }
    public void setTitle(String title)   { this.title = title; }

    public String getGenre()             { return genre; }
    public void setGenre(String genre)   { this.genre = genre; }

    public String getRating()            { return rating; }
    public void setRating(String rating) { this.rating = rating; }

    public String getRuntime()               { return runtime; }
    public void setRuntime(String runtime)   { this.runtime = runtime; }

    public String getSynopsis()              { return synopsis; }
    public void setSynopsis(String synopsis) { this.synopsis = synopsis; }

    public String getDirector()              { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getCast()              { return cast; }
    public void setCast(String cast)     { this.cast = cast; }

    public String getTrailerUrl()                  { return trailerUrl; }
    public void setTrailerUrl(String trailerUrl)   { this.trailerUrl = trailerUrl; }

    public String getPosterUrl()                   { return posterUrl; }
    public void setPosterUrl(String posterUrl)     { this.posterUrl = posterUrl; }

    public int getStars()                { return stars; }
    public void setStars(int stars)      { this.stars = stars; }

    public String getStatus()                { return status; }
    public void setStatus(String status)     { this.status = status; }
}