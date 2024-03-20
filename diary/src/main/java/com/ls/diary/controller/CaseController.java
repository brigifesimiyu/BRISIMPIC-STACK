package com.ls.diary.controller;

import com.ls.diary.model.Case;
import com.ls.diary.service.CaseService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RestController
@RequestMapping("/cases")
public class CaseController {
    private final CaseService caseService;

    @Autowired
    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }

    @GetMapping
    public List<Case> getAllCases() {
        return caseService.getAllCases();
    }

    @GetMapping("/{id}")
    public Case getCaseById(@PathVariable Long id) {
        return caseService.getCaseById(id);
    }

    @PostMapping
    public Case saveCase(@RequestBody Case acase) {
        return caseService.saveCase(acase);
    }

    @DeleteMapping("/{id}")
    public void deleteCase(@PathVariable Long id) {
        caseService.deleteCase(id);
    }
}

