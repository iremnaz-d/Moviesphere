package Starter.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "review")
public class Review {

    @Id
    @Column(name = "review_id")
    private Integer reviewId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movieId;

    @Column(name = "comment")
    private String comment;

    @Min(0)
    @Max(5)
    @NotBlank
    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @DecimalMin("0.00")
    @DecimalMax("1.00")
    @ColumnDefault("0.00")
    @Column(name = "risk_score", precision = 3, scale = 2)
    private BigDecimal riskScore;









}
