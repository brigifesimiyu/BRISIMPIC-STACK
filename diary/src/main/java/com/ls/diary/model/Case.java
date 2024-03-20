package com.ls.diary.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;

import java.util.Set;
@Data
@Entity
@Table("cases")
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "case")
    private Set<Event> events;

    // Getters and Setters
}

