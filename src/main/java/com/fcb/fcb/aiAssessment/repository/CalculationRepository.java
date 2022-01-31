package com.fcb.fcb.aiAssessment.repository;

import com.fcb.fcb.aiAssessment.entities.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationRepository extends JpaRepository<Calculation, Long> {
}
