package com.musdb.user_service.user.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.musdb.user_service.user_credential.entity.user_credential_entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class user_entity {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private user_credential_entity user_credential;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private Date birth_date;
    @Column(nullable = false)
    private Boolean is_deleted;
    @Column(nullable = false)
    private Date created_at;
    private Date updated_at;
    private user_type user_type;
    private Float rating;

    @PrePersist
    private void preDefinedValues() {
        if (is_deleted == null) {
            is_deleted = false;
        }
        if (created_at == null) {
            created_at = new Date();
        }
    }
}
