package com.example.shopping.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Authorities {

    // Getters and Setters
    @Id
    private String username;
    private String authority;

    @ManyToOne
    private User user;

}