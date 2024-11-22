package com.musdb.user_service.user_credential.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.musdb.user_service.user.entity.user_entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Random;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class user_credential_entity {
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean is_deleted;

    @OneToOne(mappedBy = "user_credential", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonManagedReference
    private user_entity user;

    @PrePersist
    private void generate_id() {
        if (id == null) {
            Random random = new Random();
            id = (long) (random.nextInt(900_000_000) + 100_000_000);
        }
    }
}
