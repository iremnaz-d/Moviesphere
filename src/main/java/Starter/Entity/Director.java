package Starter.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "director")
public class Director {
    @Id
    @Column(name = "director_id")
    private Integer directorId;

    @NotBlank
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @ManyToMany(mappedBy = "directors")
    private List<Movie> movies;

}
