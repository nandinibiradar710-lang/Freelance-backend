package com.marketplace.controller;

import com.marketplace.model.GigStatus;
import com.marketplace.model.Role;
import com.marketplace.repository.GigRepository;
import com.marketplace.repository.ProposalRepository;
import com.marketplace.repository.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/stats")
@CrossOrigin(origins = "*")
public class StatsController {

    private final GigRepository gigRepository;
    private final UserRepository userRepository;
    private final ProposalRepository proposalRepository;

    public StatsController(GigRepository gigRepository, UserRepository userRepository, ProposalRepository proposalRepository) {
        this.gigRepository = gigRepository;
        this.userRepository = userRepository;
        this.proposalRepository = proposalRepository;
    }

    @GetMapping
    public Map<String, Object> getMarketplaceStats() {
        Map<String, Object> stats = new HashMap<>();
        long totalGigs = gigRepository.count();
        long openGigs = gigRepository.findByStatus(GigStatus.OPEN).size();
        long inProgressGigs = gigRepository.findByStatus(GigStatus.IN_PROGRESS).size();
        long completedGigs = gigRepository.findByStatus(GigStatus.COMPLETED).size();
        long studentCount = userRepository.findByRole(Role.STUDENT).size();
        long clientCount = userRepository.findByRole(Role.CLIENT).size();
        long proposalCount = proposalRepository.count();

        stats.put("totalGigs", totalGigs);
        stats.put("openGigs", openGigs);
        stats.put("inProgressGigs", inProgressGigs);
        stats.put("completedGigs", completedGigs);
        stats.put("studentTalentCount", studentCount);
        stats.put("clientCount", clientCount);
        stats.put("proposalCount", proposalCount);
        stats.put("totalPaidOut", "$48,950");
        stats.put("averageStudentHourly", "$38/hr");
        stats.put("universitiesRepresented", "45+ Campuses");

        return stats;
    }
}
