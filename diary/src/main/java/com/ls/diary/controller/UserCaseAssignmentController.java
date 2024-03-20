package com.ls.diary.controller;

import com.ls.diary.model.UserCaseAssignment;
import com.ls.diary.service.UserCaseAssignmentService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RestController
@RequestMapping("/user-case-assignments")
public class UserCaseAssignmentController {
    private final UserCaseAssignmentService userCaseAssignmentService;

    @Autowired
    public UserCaseAssignmentController(UserCaseAssignmentService userCaseAssignmentService) {
        this.userCaseAssignmentService = userCaseAssignmentService;
    }

    @GetMapping
    public List<UserCaseAssignment> getAllUserCaseAssignments() {
        return userCaseAssignmentService.getAllUserCaseAssignments();
    }

    @GetMapping("/{id}")
    public UserCaseAssignment getUserCaseAssignmentById(@PathVariable Long id) {
        return userCaseAssignmentService.getUserCaseAssignmentById(id);
    }

    @PostMapping
    public UserCaseAssignment saveUserCaseAssignment(@RequestBody UserCaseAssignment userCaseAssignment) {
        return userCaseAssignmentService.saveUserCaseAssignment(userCaseAssignment);
    }

    @DeleteMapping("/{id}")
    public void deleteUserCaseAssignment(@PathVariable Long id) {
        userCaseAssignmentService.deleteUserCaseAssignment(id);
    }
}

