package com.ls.diary.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class EventDto {
    private Long id;
    private Long caseId;
    private Long userId;
    private Date date;
    private String description;
    private List<DocumentDto> documents;
    // Getters and Setters
}

