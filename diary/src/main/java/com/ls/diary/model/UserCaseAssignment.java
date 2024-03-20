package com.ls.diary.model;

import lombok.Data;

import javax.persistence.*;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Entity
@Table("user_case_assignments")
public class UserCaseAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private Case aCase;

    // Getters and Setters
}

