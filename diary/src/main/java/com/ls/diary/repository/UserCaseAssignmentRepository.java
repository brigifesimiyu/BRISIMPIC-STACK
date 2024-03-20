package com.ls.diary.repository;

import com.ls.diary.model.UserCaseAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCaseAssignmentRepository extends JpaRepository<UserCaseAssignment, Long> {
}
