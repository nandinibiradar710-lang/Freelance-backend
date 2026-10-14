package com.marketplace.controller;

import com.marketplace.model.Role;
import com.marketplace.model.User;
import com.marketplace.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/students")
    public List<User> getStudents(
            @RequestParam(required = false) String search
    ) {
        if (search != null && !search.trim().isEmpty()) {
            return userRepository.findByNameContainingIgnoreCaseOrSkillsContainingIgnoreCaseOrUniversityContainingIgnoreCase(
                    search.trim(), search.trim(), search.trim()
            ).stream().filter(u -> u.getRole() == Role.STUDENT).toList();
        }
        return userRepository.findByRole(Role.STUDENT);
    }

    @GetMapping("/clients")
    public List<User> getClients() {
        return userRepository.findByRole(Role.CLIENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (user.getRating() == null) {
            user.setRating(5.0);
        }
        if (user.getReviewCount() == null) {
            user.setReviewCount(0);
        }
        if (user.getCompletedGigs() == null) {
            user.setCompletedGigs(0);
        }
        User saved = userRepository.save(user);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User details) {
        return userRepository.findById(id).map(user -> {
            user.setName(details.getName());
            user.setUniversity(details.getUniversity());
            user.setMajor(details.getMajor());
            user.setGradYear(details.getGradYear());
            user.setBio(details.getBio());
            user.setSkills(details.getSkills());
            user.setHourlyRate(details.getHourlyRate());
            user.setAvatarUrl(details.getAvatarUrl());
            user.setGithubUrl(details.getGithubUrl());
            user.setPortfolioUrl(details.getPortfolioUrl());
            return ResponseEntity.ok(userRepository.save(user));
        }).orElse(ResponseEntity.notFound().build());
    }
}
