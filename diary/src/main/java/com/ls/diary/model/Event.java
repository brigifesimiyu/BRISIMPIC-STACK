package com.ls.diary.model;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;
import org.springframework.data.relational.core.mapping.Table;
@Data
@Entity
@Table("events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private Case aCase;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

    // Getters and Setters
}
