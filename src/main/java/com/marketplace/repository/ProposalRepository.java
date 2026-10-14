package com.marketplace.repository;

import com.marketplace.model.Proposal;
import com.marketplace.model.ProposalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    List<Proposal> findByGigId(Long gigId);
    List<Proposal> findByStudentId(Long studentId);
    List<Proposal> findByGigIdAndStatus(Long gigId, ProposalStatus status);
    boolean existsByGigIdAndStudentId(Long gigId, Long studentId);
}
