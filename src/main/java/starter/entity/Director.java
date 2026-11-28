package starter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "director_id")
    private Integer directorId;

    @NotBlank
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @ManyToMany(mappedBy = "directors")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Movie> movies;

}
