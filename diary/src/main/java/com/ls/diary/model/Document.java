package com.ls.diary.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.*;

@Data
@Entity
@Table("documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_name")
    private String fileName;

    // Getters and Setters
}

