package irem_kadir.Moviesphere.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "link")
public class Link {

    @Id
    @Column(name = "movie_id")
    private String movieId;

    @Column(name = "imdb_id")
    private String imdbId;
}
