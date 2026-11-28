package starter.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @Column(name  ="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "userId")
    private List<Review> reviews;

    /**
    SELECT m.*
    FROM users u
    JOIN favourite_list fl ON u.user_id = fl.user_id     -- Step 1: joinColumns
    JOIN movie m          ON fl.movie_id = m.movie_id    -- Step 2: inverseJoinColumns
    WHERE u.user_id = ?;
     */
    @ManyToMany
    @JoinTable(
            name = "favourite_list",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> favouriteList;

    @ManyToMany
    @JoinTable(
            name = "watch_later_list",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> watchLaterList;
}
