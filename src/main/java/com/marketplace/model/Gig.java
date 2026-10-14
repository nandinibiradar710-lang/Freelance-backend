package com.marketplace.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "gigs")
public class Gig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 4000)
    private String description;

    @Column(nullable = false)
    private String category; // e.g. "Web Development", "AI & Machine Learning", "UI/UX Design", "Academic Tutoring", "Content Writing"

    @Column(nullable = false)
    private Double budget;

    private String budgetType; // "FIXED" or "HOURLY"
    private String duration; // e.g. "1-2 weeks", "3 days"
    private String difficulty; // "BEGINNER", "INTERMEDIATE", "ADVANCED"

    @Enumerated(EnumType.STRING)
    private GigStatus status = GigStatus.OPEN;

    private Long clientId;
    private String clientName;
    private String clientUniversity;
    private String clientAvatar;

    private Long assignedStudentId;
    private String assignedStudentName;

    private String requiredSkills; // Comma separated e.g. "React, Tailwind, Spring Boot"
    private Integer applicantsCount = 0;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Gig() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getBudget() { return budget; }
    public void setBudget(Double budget) { this.budget = budget; }

    public String getBudgetType() { return budgetType; }
    public void setBudgetType(String budgetType) { this.budgetType = budgetType; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public GigStatus getStatus() { return status; }
    public void setStatus(GigStatus status) { this.status = status; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getClientUniversity() { return clientUniversity; }
    public void setClientUniversity(String clientUniversity) { this.clientUniversity = clientUniversity; }

    public String getClientAvatar() { return clientAvatar; }
    public void setClientAvatar(String clientAvatar) { this.clientAvatar = clientAvatar; }

    public Long getAssignedStudentId() { return assignedStudentId; }
    public void setAssignedStudentId(Long assignedStudentId) { this.assignedStudentId = assignedStudentId; }

    public String getAssignedStudentName() { return assignedStudentName; }
    public void setAssignedStudentName(String assignedStudentName) { this.assignedStudentName = assignedStudentName; }

    public String getRequiredSkills() { return requiredSkills; }
    public void setRequiredSkills(String requiredSkills) { this.requiredSkills = requiredSkills; }

    public Integer getApplicantsCount() { return applicantsCount; }
    public void setApplicantsCount(Integer applicantsCount) { this.applicantsCount = applicantsCount; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
