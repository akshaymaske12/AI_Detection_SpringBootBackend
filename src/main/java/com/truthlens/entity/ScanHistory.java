package com.truthlens.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "scan_history")
public class ScanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userEmail;

    private String filename;
    private String meta;
    private String verdict;
    private String confidence;

    @Column(length = 1000)
    private String description;

    @Column(columnDefinition = "TEXT")
    private String tags;

    @Column(columnDefinition = "TEXT")
    private String scores;

    private boolean isImage;

    @Column(columnDefinition = "LONGTEXT")
    private String previewUrl;

    private LocalDateTime createdAt;

    public ScanHistory() {
        this.createdAt = LocalDateTime.now();
    }

    public ScanHistory(Long id, String userEmail, String filename, String meta, String verdict,
                       String confidence, String description, String tags, String scores,
                       boolean isImage, String previewUrl, LocalDateTime createdAt) {
        this.id = id;
        this.userEmail = userEmail;
        this.filename = filename;
        this.meta = meta;
        this.verdict = verdict;
        this.confidence = confidence;
        this.description = description;
        this.tags = tags;
        this.scores = scores;
        this.isImage = isImage;
        this.previewUrl = previewUrl;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public String getVerdict() {
        return verdict;
    }

    public void setVerdict(String verdict) {
        this.verdict = verdict;
    }

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = scores;
    }

    public boolean isImage() {
        return isImage;
    }

    public void setImage(boolean isImage) {
        this.isImage = isImage;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
