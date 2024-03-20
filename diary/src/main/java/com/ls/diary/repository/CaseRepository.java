package com.ls.diary.repository;

import com.ls.diary.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends JpaRepository <Case, Long> {
}
