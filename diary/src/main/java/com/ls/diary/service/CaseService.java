package com.ls.diary.service;

import com.ls.diary.model.Case;
import com.ls.diary.repository.CaseRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Data
@Service
@EnableJpaRepositories
public class CaseService {
    private final CaseRepository caseRepository;

    @Autowired
    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public List<Case> getAllCases() {
        return caseRepository.findAll();
    }

    public Case getCaseById(Long id) {
        return caseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Case not found with ID: " + id));

    }

    public Case saveCase(Case acase) {
        return caseRepository.save(acase);
    }

    public void deleteCase(Long id) {
        caseRepository.deleteById(id);
    }
}

