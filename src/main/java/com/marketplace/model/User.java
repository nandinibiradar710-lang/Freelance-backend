package com.marketplace.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String university;
    private String major;
    private String gradYear;

    @Column(length = 2000)
    private String bio;

    private String skills; // Comma separated e.g. "React, Python, Figma"
    private Double hourlyRate;
    private String avatarUrl;
    private Double rating;
    private Integer reviewCount;
    private Integer completedGigs;
    private Boolean verifiedStudent;
    private String githubUrl;
    private String portfolioUrl;

    private LocalDateTime createdAt = LocalDateTime.now();

    public User() {
    }

    public User(Long id, String name, String email, Role role, String university, String major, String gradYear, String bio, String skills, Double hourlyRate, String avatarUrl, Double rating, Integer reviewCount, Integer completedGigs, Boolean verifiedStudent, String githubUrl, String portfolioUrl) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.university = university;
        this.major = major;
        this.gradYear = gradYear;
        this.bio = bio;
        this.skills = skills;
        this.hourlyRate = hourlyRate;
        this.avatarUrl = avatarUrl;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.completedGigs = completedGigs;
        this.verifiedStudent = verifiedStudent;
        this.githubUrl = githubUrl;
        this.portfolioUrl = portfolioUrl;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    public String getUniversity() { return university; }
    public void setUniversity(String university) { this.university = university; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }

    public String getGradYear() { return gradYear; }
    public void setGradYear(String gradYear) { this.gradYear = gradYear; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public Double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(Double hourlyRate) { this.hourlyRate = hourlyRate; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public Integer getReviewCount() { return reviewCount; }
    public void setReviewCount(Integer reviewCount) { this.reviewCount = reviewCount; }

    public Integer getCompletedGigs() { return completedGigs; }
    public void setCompletedGigs(Integer completedGigs) { this.completedGigs = completedGigs; }

    public Boolean getVerifiedStudent() { return verifiedStudent; }
    public void setVerifiedStudent(Boolean verifiedStudent) { this.verifiedStudent = verifiedStudent; }

    public String getGithubUrl() { return githubUrl; }
    public void setGithubUrl(String githubUrl) { this.githubUrl = githubUrl; }

    public String getPortfolioUrl() { return portfolioUrl; }
    public void setPortfolioUrl(String portfolioUrl) { this.portfolioUrl = portfolioUrl; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
