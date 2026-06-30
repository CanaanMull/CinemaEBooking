-- ============================================================
--  CinemaEBooking — SQLite Schema + Seed Data
--  Place this file at:
--  src/main/resources/db/schema-and-seed.sql
-- ============================================================

-- Drop table if it already exists (safe to re-run)
DROP TABLE IF EXISTS movies;

-- Create the movies table
CREATE TABLE movies (
                        id          INTEGER PRIMARY KEY AUTOINCREMENT,
                        title       TEXT    NOT NULL,
                        genre       TEXT    NOT NULL,
                        rating      TEXT    NOT NULL,       -- MPAA rating: G, PG, PG-13, R
                        runtime     TEXT    NOT NULL,       -- e.g. "2h 14m"
                        synopsis    TEXT,
                        director    TEXT,
                        cast        TEXT,
                        trailer_url TEXT,
                        poster_url  TEXT,
                        stars       INTEGER DEFAULT 3,      -- 1–5 star rating
                        status      TEXT    NOT NULL        -- 'now-playing' or 'coming-soon'
);

-- ============================================================
--  SEED DATA — 10 movies (mix of genres and statuses)
-- ============================================================

INSERT INTO movies (title, genre, rating, runtime, synopsis, director, cast, trailer_url, poster_url, stars, status) VALUES
                                                                                                                         (
                                                                                                                             'Dune: Part Two',
                                                                                                                             'sci-fi',
                                                                                                                             'PG-13',
                                                                                                                             '2h 46m',
                                                                                                                             'Paul Atreides unites with Chani and the Fremen while on a warpath of revenge against the conspirators who destroyed his family.',
                                                                                                                             'Denis Villeneuve',
                                                                                                                             'Timothée Chalamet, Zendaya, Rebecca Ferguson',
                                                                                                                             'https://www.youtube.com/embed/Way9Dexny3w',
                                                                                                                             'https://images.unsplash.com/photo-1446776811953-b23d57bd21aa?w=400&q=80',
                                                                                                                             5,
                                                                                                                             'now-playing'
                                                                                                                         ),
                                                                                                                         (
                                                                                                                             'Civil War',
                                                                                                                             'action',
                                                                                                                             'R',
                                                                                                                             '1h 49m',
                                                                                                                             'A journey across a dystopian future America, following a team of military-embedded journalists as they race against time to reach DC before rebel factions descend on the White House.',
                                                                                                                             'Alex Garland',
                                                                                                                             'Kirsten Dunst, Wagner Moura, Cailee Spaeny',
                                                                                                                             'https://www.youtube.com/embed/aDyQxtg0V2w',
                                                                                                                             'https://images.unsplash.com/photo-1531219572328-a0171b4448a3?w=400&q=80',
                                                                                                                             4,
                                                                                                                             'now-playing'
                                                                                                                         ),
                                                                                                                         (
                                                                                                                             'Immaculate',
                                                                                                                             'horror',
                                                                                                                             'R',
                                                                                                                             '1h 29m',
                                                                                                                             'An American nun relocates to a remote Italian convent, only to find herself at the center of a horrifying mystery.',
                                                                                                                             'Michael Mohan',
                                                                                                                             'Sydney Sweeney, Álvaro Morte, Benedetta Porcaroli',
                                                                                                                             'https://www.youtube.com/embed/9PZt77WKkoc',
                                                                                                                             'https://images.unsplash.com/photo-1509248961158-e54f6934749c?w=400&q=80',
                                                                                                                             3,
                                                                                                                             'now-playing'
                                                                                                                         ),
                                                                                                                         (
                                                                                                                             'Ghostbusters: Frozen Empire',
                                                                                                                             'comedy',
                                                                                                                             'PG',
                                                                                                                             '1h 55m',
                                                                                                                             'The Spengler family returns to the iconic New York City firehouse where the original Ghostbusters have taken on a new threat that could send the world into a second Ice Age.',
                                                                                                                             'Gil Kenan',
                                                                                                                             'Paul Rudd, Carrie Coon, Finn Wolfhard',
                                                                                                                             'https://www.youtube.com/embed/HpOBXh02rVc',
                                                                                                                             'https://images.unsplash.com/photo-1535016120720-40c646be5580?w=400&q=80',
                                                                                                                             4,
                                                                                                                             'now-playing'
                                                                                                                         ),
                                                                                                                         (
                                                                                                                             'Kung Fu Panda 4',
                                                                                                                             'animation',
                                                                                                                             'PG',
                                                                                                                             '1h 34m',
                                                                                                                             'Po must train a new Dragon Warrior while facing a shape-shifting villain called the Chameleon, who threatens the Valley of Peace.',
                                                                                                                             'Mike Mitchell',
                                                                                                                             'Jack Black, Viola Davis, Bryan Cranston',
                                                                                                                             'https://www.youtube.com/embed/_inKs4eeHiI',
                                                                                                                             'https://images.unsplash.com/photo-1510511459019-5dda7724fd87?w=400&q=80',
                                                                                                                             4,
                                                                                                                             'now-playing'
                                                                                                                         ),
                                                                                                                         (
                                                                                                                             'Monkey Man',
                                                                                                                             'action',
                                                                                                                             'R',
                                                                                                                             '2h 1m',
                                                                                                                             'A young man emerges from prison hell-bent on exacting vengeance against the corrupt leaders who murdered his mother and terrorized his community.',
                                                                                                                             'Dev Patel',
                                                                                                                             'Dev Patel, Sharlto Copley, Sobhita Dhulipala',
                                                                                                                             'https://www.youtube.com/embed/g8zxiB5Qhsc',
                                                                                                                             'https://images.unsplash.com/photo-1549399542-7e3f8b79c341?w=400&q=80',
                                                                                                                             4,
                                                                                                                             'now-playing'
                                                                                                                         ),
                                                                                                                         (
                                                                                                                             'Cabrini',
                                                                                                                             'drama',
                                                                                                                             'PG-13',
                                                                                                                             '2h 23m',
                                                                                                                             'The story of Italian immigrant Francesca Cabrini, who arrived in New York City in 1889 and persuaded the mayor to give her a crumbling building to house the city''s most desperate children.',
                                                                                                                             'Alejandro Monteverde',
                                                                                                                             'Cristiana Dell''Anna, David Morse, John Lithgow',
                                                                                                                             'https://www.youtube.com/embed/cuOQbToSU8M',
                                                                                                                             'https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?w=400&q=80',
                                                                                                                             4,
                                                                                                                             'now-playing'
                                                                                                                         ),
                                                                                                                         (
                                                                                                                             'Godzilla x Kong: The New Empire',
                                                                                                                             'action',
                                                                                                                             'PG-13',
                                                                                                                             '1h 55m',
                                                                                                                             'Two ancient titans, Godzilla and Kong, clash in an epic battle as humans unravel their intertwined origins and connection to Skull Island''s mysteries.',
                                                                                                                             'Adam Wingard',
                                                                                                                             'Rebecca Hall, Brian Tyree Henry, Dan Stevens',
                                                                                                                             'https://www.youtube.com/embed/lV1OOlGwExM',
                                                                                                                             'https://images.unsplash.com/photo-1478720568477-152d9b164e26?w=400&q=80',
                                                                                                                             3,
                                                                                                                             'now-playing'
                                                                                                                         ),
                                                                                                                         (
                                                                                                                             'A Quiet Place: Day One',
                                                                                                                             'horror',
                                                                                                                             'PG-13',
                                                                                                                             '1h 39m',
                                                                                                                             'Experience the day the world went quiet — the origin story of the alien invasion that forced humanity into silence to survive.',
                                                                                                                             'Michael Sarnoski',
                                                                                                                             'Lupita Nyong''o, Joseph Quinn, Alex Wolff',
                                                                                                                             'https://www.youtube.com/embed/YPY7J-flzE8',
                                                                                                                             'https://images.unsplash.com/photo-1518834107812-67b0b7c58434?w=400&q=80',
                                                                                                                             4,
                                                                                                                             'coming-soon'
                                                                                                                         ),
                                                                                                                         (
                                                                                                                             'Inside Out 2',
                                                                                                                             'animation',
                                                                                                                             'PG',
                                                                                                                             '1h 40m',
                                                                                                                             'Riley enters adolescence and her Headquarters undergoes a sudden demolition to make room for something entirely unexpected — new Emotions.',
                                                                                                                             'Kelsey Mann',
                                                                                                                             'Amy Poehler, Maya Hawke, Kensington Tallman',
                                                                                                                             'https://www.youtube.com/embed/LEjhY15eCx0',
                                                                                                                             'https://images.unsplash.com/photo-1462275646964-a0e3386b89fa?w=400&q=80',
                                                                                                                             5,
                                                                                                                             'coming-soon'
                                                                                                                         ),
                                                                                                                         (
                                                                                                                             'Deadpool & Wolverine',
                                                                                                                             'action',
                                                                                                                             'R',
                                                                                                                             '2h 7m',
                                                                                                                             'Deadpool is recruited by the Time Variance Authority and forms an unlikely alliance with a variant Wolverine to protect his world from an extinction-level threat.',
                                                                                                                             'Shawn Levy',
                                                                                                                             'Ryan Reynolds, Hugh Jackman, Emma Corrin',
                                                                                                                             'https://www.youtube.com/embed/73_1biulkYk',
                                                                                                                             'https://images.unsplash.com/photo-1611162616475-46b635cb6868?w=400&q=80',
                                                                                                                             5,
                                                                                                                             'coming-soon'
                                                                                                                         ),
                                                                                                                         (
                                                                                                                             'Alien: Romulus',
                                                                                                                             'sci-fi',
                                                                                                                             'R',
                                                                                                                             '1h 59m',
                                                                                                                             'A group of young space colonizers come face to face with the most terrifying life form in the universe while scavenging the depths of an abandoned space station.',
                                                                                                                             'Fede Álvarez',
                                                                                                                             'Cailee Spaeny, David Jonsson, Archie Renaux',
                                                                                                                             'https://www.youtube.com/embed/OzY2r2JXsDM',
                                                                                                                             'https://images.unsplash.com/photo-1516912481808-3406841bd33c?w=400&q=80',
                                                                                                                             4,
                                                                                                                             'coming-soon'
                                                                                                                         );
-- ============================================================
--  SHOWTIMES — table only. Rows are generated at startup by
--  ShowtimeSeeder.java, relative to today's date.
-- ============================================================
DROP TABLE IF EXISTS showtimes;
CREATE TABLE showtimes (
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    movie_id    INTEGER NOT NULL,
    show_date   TEXT    NOT NULL,
    show_time   TEXT    NOT NULL,
    auditorium  TEXT,
    FOREIGN KEY (movie_id) REFERENCES movies(id)
);