package com.marketplace.controller;

import com.marketplace.model.Gig;
import com.marketplace.model.GigStatus;
import com.marketplace.model.Proposal;
import com.marketplace.model.ProposalStatus;
import com.marketplace.repository.GigRepository;
import com.marketplace.repository.ProposalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proposals")
@CrossOrigin(origins = "*")
public class ProposalController {

    private final ProposalRepository proposalRepository;
    private final GigRepository gigRepository;

    public ProposalController(ProposalRepository proposalRepository, GigRepository gigRepository) {
        this.proposalRepository = proposalRepository;
        this.gigRepository = gigRepository;
    }

    @GetMapping
    public List<Proposal> getAllProposals() {
        return proposalRepository.findAll();
    }

    @GetMapping("/gig/{gigId}")
    public List<Proposal> getProposalsByGig(@PathVariable Long gigId) {
        return proposalRepository.findByGigId(gigId);
    }

    @GetMapping("/student/{studentId}")
    public List<Proposal> getProposalsByStudent(@PathVariable Long studentId) {
        return proposalRepository.findByStudentId(studentId);
    }

    @PostMapping
    public ResponseEntity<?> submitProposal(@RequestBody Proposal proposal) {
        Optional<Gig> gigOpt = gigRepository.findById(proposal.getGigId());
        if (gigOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Gig not found");
        }

        Gig gig = gigOpt.get();
        proposal.setGigTitle(gig.getTitle());
        proposal.setStatus(ProposalStatus.PENDING);
        Proposal saved = proposalRepository.save(proposal);

        // Increment applicants count
        gig.setApplicantsCount((gig.getApplicantsCount() == null ? 0 : gig.getApplicantsCount()) + 1);
        gigRepository.save(gig);

        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}/accept")
    public ResponseEntity<?> acceptProposal(@PathVariable Long id) {
        return proposalRepository.findById(id).map(proposal -> {
            proposal.setStatus(ProposalStatus.ACCEPTED);
            Proposal savedProposal = proposalRepository.save(proposal);

            // Update associated gig
            gigRepository.findById(proposal.getGigId()).ifPresent(gig -> {
                gig.setStatus(GigStatus.IN_PROGRESS);
                gig.setAssignedStudentId(proposal.getStudentId());
                gig.setAssignedStudentName(proposal.getStudentName());
                gigRepository.save(gig);
            });

            return ResponseEntity.ok(savedProposal);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<?> rejectProposal(@PathVariable Long id) {
        return proposalRepository.findById(id).map(proposal -> {
            proposal.setStatus(ProposalStatus.REJECTED);
            return ResponseEntity.ok(proposalRepository.save(proposal));
        }).orElse(ResponseEntity.notFound().build());
    }
}
