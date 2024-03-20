package com.ls.diary.service;

import com.ls.diary.model.UserCaseAssignment;
import com.ls.diary.repository.UserCaseAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserCaseAssignmentService {
    private final UserCaseAssignmentRepository userCaseAssignmentRepository;

    @Autowired
    public UserCaseAssignmentService(UserCaseAssignmentRepository userCaseAssignmentRepository) {
        this.userCaseAssignmentRepository = userCaseAssignmentRepository;
    }

    public List<UserCaseAssignment> getAllUserCaseAssignments() {
        return userCaseAssignmentRepository.findAll();
    }

    public UserCaseAssignment getUserCaseAssignmentById(Long id) {
        return userCaseAssignmentRepository.findById(id).orElse(null);
    }

    public UserCaseAssignment saveUserCaseAssignment(UserCaseAssignment userCaseAssignment) {
        return userCaseAssignmentRepository.save(userCaseAssignment);
    }

    public void deleteUserCaseAssignment(Long id) {
        userCaseAssignmentRepository.deleteById(id);
    }
}

