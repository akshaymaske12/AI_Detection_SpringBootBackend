package com.truthlens.dto;

import java.util.List;

public class ScanHistoryRequest {

    private String userEmail;
    private String filename;
    private String meta;
    private String verdict;
    private String confidence;
    private String desc;
    private List<String> tags;
    private List<String> scores;
    private boolean isImage;
    private String previewUrl;

    public ScanHistoryRequest() {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getScores() {
        return scores;
    }

    public void setScores(List<String> scores) {
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
}
