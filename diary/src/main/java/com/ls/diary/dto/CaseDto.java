package com.ls.diary.dto;

import lombok.Data;

import java.util.List;
@Data
public class CaseDto {
    private Long id;
    private String title;
    private String description;
    private List<EventDto> events;
    // Getters and Setters
}

