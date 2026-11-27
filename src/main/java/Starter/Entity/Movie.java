package Starter.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "original_language")
    private String originalLanguage;

    @NotBlank
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "genres")
    @ManyToMany
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @Column(name = "poster_path")
    private String posterPath;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "avg_rating", precision = 3, scale = 2)
    private float avgRating;

    @Column(name  ="duration")
    private int duration;

    @Column(name = "overview")
    private String overview;

    @Column(name = "primary_company")
    private String primaryCompany;

    @Column(name = "primary_country")
    private String primaryCountry;

    @OneToMany(mappedBy = "movie_id")
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
    private List<Actor> actors; //bu tabloya character_name eklemek istersek ayrı entity olarak da yazabiliriz


}
