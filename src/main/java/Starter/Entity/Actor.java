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
@Table(name = "actor")
public class Actor {

    @Id
    @Column(name = "actor_id")
    private Integer actorId;

    @NotBlank
    @Column(name = "full_name")
    private String fullName;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;
}
