package com.marketplace.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "proposals")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long gigId;

    private String gigTitle;

    @Column(nullable = false)
    private Long studentId;

    private String studentName;
    private String studentUniversity;
    private String studentMajor;
    private String studentAvatar;
    private Double studentRating;

    @Column(nullable = false, length = 3000)
    private String coverLetter;

    @Column(nullable = false)
    private Double bidAmount;

    private Integer estimatedDays;

    @Enumerated(EnumType.STRING)
    private ProposalStatus status = ProposalStatus.PENDING;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Proposal() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getGigId() { return gigId; }
    public void setGigId(Long gigId) { this.gigId = gigId; }

    public String getGigTitle() { return gigTitle; }
    public void setGigTitle(String gigTitle) { this.gigTitle = gigTitle; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getStudentUniversity() { return studentUniversity; }
    public void setStudentUniversity(String studentUniversity) { this.studentUniversity = studentUniversity; }

    public String getStudentMajor() { return studentMajor; }
    public void setStudentMajor(String studentMajor) { this.studentMajor = studentMajor; }

    public String getStudentAvatar() { return studentAvatar; }
    public void setStudentAvatar(String studentAvatar) { this.studentAvatar = studentAvatar; }

    public Double getStudentRating() { return studentRating; }
    public void setStudentRating(Double studentRating) { this.studentRating = studentRating; }

    public String getCoverLetter() { return coverLetter; }
    public void setCoverLetter(String coverLetter) { this.coverLetter = coverLetter; }

    public Double getBidAmount() { return bidAmount; }
    public void setBidAmount(Double bidAmount) { this.bidAmount = bidAmount; }

    public Integer getEstimatedDays() { return estimatedDays; }
    public void setEstimatedDays(Integer estimatedDays) { this.estimatedDays = estimatedDays; }

    public ProposalStatus getStatus() { return status; }
    public void setStatus(ProposalStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
