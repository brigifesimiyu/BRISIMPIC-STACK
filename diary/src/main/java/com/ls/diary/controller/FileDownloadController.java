package com.ls.diary.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



import com.ls.diary.service.FileUploadService;

import java.io.IOException;

@RestController
public class FileDownloadController {

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("/downloadFile/{filecode}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filecode, HttpServletRequest request) {
        Resource resource = fileUploadService.loadFileAsResource(filecode);

        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            // Log the exception or handle it as needed
        }

        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
