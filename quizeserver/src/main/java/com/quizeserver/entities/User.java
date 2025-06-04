package com.quizeserver.entities;

import com.quizeserver.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
