package irem_kadir.Moviesphere.Entity;

import jakarta.persistence.*;
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
    @Column
    private String id;

    @Column(name = "original_language")
    private String originalLanguage;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "title")
    private String title;

    @Column
    private String tagline;


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

    @Column(name = "vote_average")
    private float voteAverage;

    @Column(name = "vote_count")
    private int voteCount;

    @Column
    private int runtime;

    @Column
    private String overview;




}
