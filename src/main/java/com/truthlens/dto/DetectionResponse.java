package com.truthlens.dto;

import java.util.List;

public class DetectionResponse {

    private String filename;
    private String meta;
    private String verdict;
    private String confidence;
    private String desc;
    private List<String> tags;
    private List<String> scores;
    private boolean isImage;
    private String icon;

    public DetectionResponse() {
    }

    public DetectionResponse(String filename, String meta, String verdict, String confidence,
                             String desc, List<String> tags, List<String> scores, boolean isImage, String icon) {
        this.filename = filename;
        this.meta = meta;
        this.verdict = verdict;
        this.confidence = confidence;
        this.desc = desc;
        this.tags = tags;
        this.scores = scores;
        this.isImage = isImage;
        this.icon = icon;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
