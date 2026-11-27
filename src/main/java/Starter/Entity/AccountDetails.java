package Starter.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Check(constraints = "status IN ('ACTIVE', 'INACTIVE', 'SUSPENDED')")
@Table(name = "account_details")
public class AccountDetails {

    @OneToOne
    @JoinColumn(name = "user_id")
    @Id
    private User userId;

    @NotBlank
    @Column(name = "username", unique = true, nullable = false)
    private String userName;

    @NotBlank
    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "deletion_date")
    private LocalDateTime deletionDate;

    @ColumnDefault("'ACTIVE'")
    @Column(name = "status")
    private String status;

    @NotBlank
    @Column(name = "is_admin")
    private boolean isAdmin;






}
