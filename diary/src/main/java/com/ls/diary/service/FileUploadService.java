package com.ls.diary.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadService {

    private final Path fileStorageLocation = Paths.get("uploads");

    public String saveFile(String fileName, MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.fileStorageLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            // Log the exception or handle it as needed
            return null; // Return null or an appropriate response indicating failure
        }
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                // Log the exception or handle it as needed
                return null; // Return null or an appropriate response indicating failure
            }
        } catch (MalformedURLException ex) {
            // Log the exception or handle it as needed
            return null; // Return null or an appropriate response indicating failure
        }
    }
}
