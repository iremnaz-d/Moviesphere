package starter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_details")
public class AccountDetails {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private Users user;

    @NotBlank
    @Column(name = "username", length = 64, unique = true, nullable = false)
    private String userName;

    @NotBlank
    @Column(name = "password_hash", length = 256, nullable = false)
    private String passwordHash;

    @CreationTimestamp
    @Column(name = "creation_date", updatable = false)
    private LocalDateTime creationDate;

    @Column(name = "deletion_date")
    private LocalDateTime deletionDate;

    @Column(name = "account_status", length = 25, nullable = false)
    private String accountStatus = "ACTIVE";

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin = false;
}
