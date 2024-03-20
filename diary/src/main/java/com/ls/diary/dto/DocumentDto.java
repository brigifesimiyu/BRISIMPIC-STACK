package com.ls.diary.dto;

import lombok.Data;

@Data
public class DocumentDto {
    private Long id;
    private Long eventId;
    private String filePath;
    private String fileName;
    // Getters and Setters
}

