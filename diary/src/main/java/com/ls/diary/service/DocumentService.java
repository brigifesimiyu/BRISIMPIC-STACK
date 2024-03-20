package com.ls.diary.service;

import com.ls.diary.model.Document;
import com.ls.diary.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Document getDocumentById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}

