package com.marketplace.controller;

import com.marketplace.model.Gig;
import com.marketplace.model.GigStatus;
import com.marketplace.repository.GigRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/gigs")
@CrossOrigin(origins = "*")
public class GigController {

    private final GigRepository gigRepository;

    public GigController(GigRepository gigRepository) {
        this.gigRepository = gigRepository;
    }

    @GetMapping
    public List<Gig> getAllGigs(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) GigStatus status
    ) {
        if (search != null && !search.trim().isEmpty()) {
            return gigRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrRequiredSkillsContainingIgnoreCase(
                    search.trim(), search.trim(), search.trim()
            );
        }
        if (category != null && !category.trim().isEmpty() && !category.equalsIgnoreCase("all")) {
            return gigRepository.findByCategoryIgnoreCase(category.trim());
        }
        if (status != null) {
            return gigRepository.findByStatus(status);
        }
        return gigRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gig> getGigById(@PathVariable Long id) {
        return gigRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Gig> createGig(@RequestBody Gig gig) {
        if (gig.getStatus() == null) {
            gig.setStatus(GigStatus.OPEN);
        }
        if (gig.getApplicantsCount() == null) {
            gig.setApplicantsCount(0);
        }
        Gig saved = gigRepository.save(gig);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gig> updateGig(@PathVariable Long id, @RequestBody Gig gigDetails) {
        return gigRepository.findById(id).map(gig -> {
            gig.setTitle(gigDetails.getTitle());
            gig.setDescription(gigDetails.getDescription());
            gig.setCategory(gigDetails.getCategory());
            gig.setBudget(gigDetails.getBudget());
            gig.setBudgetType(gigDetails.getBudgetType());
            gig.setDuration(gigDetails.getDuration());
            gig.setDifficulty(gigDetails.getDifficulty());
            gig.setRequiredSkills(gigDetails.getRequiredSkills());
            if (gigDetails.getStatus() != null) {
                gig.setStatus(gigDetails.getStatus());
            }
            return ResponseEntity.ok(gigRepository.save(gig));
        }).orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Gig> updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        return gigRepository.findById(id).map(gig -> {
            String newStatus = body.get("status");
            if (newStatus != null) {
                gig.setStatus(GigStatus.valueOf(newStatus.toUpperCase()));
            }
            return ResponseEntity.ok(gigRepository.save(gig));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGig(@PathVariable Long id) {
        if (gigRepository.existsById(id)) {
            gigRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/categories")
    public List<String> getCategories() {
        return List.of(
                "All",
                "Web Development",
                "Mobile Apps",
                "AI & Machine Learning",
                "UI/UX Design",
                "Academic Tutoring",
                "Content & Copywriting",
                "Data Analysis & Python",
                "Video Editing & Media"
        );
    }
}
