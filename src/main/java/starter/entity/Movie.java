package starter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "original_language", length = 10)
    private String originalLanguage;

    @NotBlank
    @Column(name = "title", length = 256, nullable = false)
    private String title;


    /*
     * 1) CONCEPTUAL / RAW SQL (3-Table Full JOIN):
     *    Direct equivalent of @JoinTable (executed when using "JOIN FETCH m.genres" in JPQL):
     *
     *    SELECT m.*, g.*
     *    FROM movie m
     *    JOIN movie_genre mg ON m.movie_id = mg.movie_id   -- joinColumns (FK of the owning entity)
     *    JOIN genre g        ON mg.genre_id = g.genre_id   -- inverseJoinColumns (FK of the target entity)
     *    WHERE m.movie_id = ?;
     *
     * 2) HIBERNATE OPTIMIZATION (Default Lazy Loading):
     *    If the Movie entity is already loaded in memory (movie_id is known), Hibernate skips
     *    joining the "movie" table again and queries the junction table directly:
     *
     *    SELECT g.genre_id, g.name
     *    FROM movie_genre mg
     *    JOIN genre g ON mg.genre_id = g.genre_id
     *    WHERE mg.movie_id = ?;
     *
     * 3) INSERT EQUIVALENT (Adding a Genre):
     *    Executed when adding a genre via movie.getGenres().add(genre) and saving:
     *
     *    INSERT INTO movie_genre (movie_id, genre_id) VALUES (?, ?);
     */

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    @Column(name = "poster_path", length = 256)
    private String posterPath;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "avg_rating", precision = 3, scale = 2)
    private BigDecimal avgRating = BigDecimal.ZERO;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "overview", columnDefinition = "TEXT")
    private String overview;

    @Column(name = "primary_company", length = 256)
    private String primaryCompany;

    @Column(name = "primary_country", length = 100)
    private String primaryCountry;


    @OneToMany(mappedBy = "movieId")
    private List<Review> reviews;

    @ManyToMany
    @JoinTable(
            name = "movie_director",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    private List<Director> directors;

    @ManyToMany
    @JoinTable(
            name = "movie_actor",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;
}
