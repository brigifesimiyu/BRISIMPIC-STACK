package com.ls.diary.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;

import java.util.Set;
@Data
@Entity
@Table("users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<UserCaseAssignment> userCaseAssignments;

    // Getters and Setters
}

