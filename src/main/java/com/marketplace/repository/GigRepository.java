package com.marketplace.repository;

import com.marketplace.model.Gig;
import com.marketplace.model.GigStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GigRepository extends JpaRepository<Gig, Long> {
    List<Gig> findByStatus(GigStatus status);
    List<Gig> findByCategoryIgnoreCase(String category);
    List<Gig> findByClientId(Long clientId);
    List<Gig> findByAssignedStudentId(Long studentId);
    List<Gig> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrRequiredSkillsContainingIgnoreCase(String title, String desc, String skills);
}
