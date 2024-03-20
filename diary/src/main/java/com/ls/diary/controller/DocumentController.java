package com.ls.diary.controller;

import com.ls.diary.model.Document;
import com.ls.diary.service.DocumentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping
    public List<Document> getAllDocuments() {
        return documentService.getAllDocuments();
    }

    @GetMapping("/{id}")
    public Document getDocumentById(@PathVariable Long id) {
        return documentService.getDocumentById(id);
    }

    @PostMapping
    public Document saveDocument(@RequestBody Document document) {
        return documentService.saveDocument(document);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
    }
}

