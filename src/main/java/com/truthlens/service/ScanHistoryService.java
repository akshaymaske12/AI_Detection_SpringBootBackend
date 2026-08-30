package com.truthlens.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.truthlens.dto.ScanHistoryRequest;
import com.truthlens.dto.ScanHistoryResponse;
import com.truthlens.entity.ScanHistory;
import com.truthlens.repository.ScanHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScanHistoryService {

    @Autowired
    private ScanHistoryRepository scanHistoryRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy, h:mm:ss a");

    public ScanHistoryResponse saveScan(ScanHistoryRequest request) {
        ScanHistory history = new ScanHistory();
        history.setUserEmail(request.getUserEmail());
        history.setFilename(request.getFilename());
        history.setMeta(request.getMeta());
        history.setVerdict(request.getVerdict());
        history.setConfidence(request.getConfidence());
        history.setDescription(request.getDesc());
        history.setImage(request.isImage());
        history.setPreviewUrl(request.getPreviewUrl());

        try {
            if (request.getTags() != null) {
                history.setTags(objectMapper.writeValueAsString(request.getTags()));
            }
            if (request.getScores() != null) {
                history.setScores(objectMapper.writeValueAsString(request.getScores()));
            }
        } catch (Exception e) {
            history.setTags("[]");
            history.setScores("[]");
        }

        ScanHistory saved = scanHistoryRepository.save(history);
        return mapToResponse(saved);
    }

    public List<ScanHistoryResponse> getUserHistory(String userEmail) {
        List<ScanHistory> list = scanHistoryRepository.findByUserEmailOrderByCreatedAtDesc(userEmail);
        List<ScanHistoryResponse> responses = new ArrayList<>();
        for (ScanHistory history : list) {
            responses.add(mapToResponse(history));
        }
        return responses;
    }

    private ScanHistoryResponse mapToResponse(ScanHistory history) {
        ScanHistoryResponse res = new ScanHistoryResponse();
        res.setId(history.getId());
        res.setUserEmail(history.getUserEmail());
        res.setFilename(history.getFilename());
        res.setMeta(history.getMeta());
        res.setVerdict(history.getVerdict());
        res.setConfidence(history.getConfidence());
        res.setDesc(history.getDescription());
        res.setImage(history.isImage());
        res.setPreviewUrl(history.getPreviewUrl());

        if (history.getCreatedAt() != null) {
            res.setDate(history.getCreatedAt().format(formatter));
        }

        try {
            if (history.getTags() != null && !history.getTags().isEmpty()) {
                res.setTags(objectMapper.readValue(history.getTags(), new TypeReference<List<String>>() {}));
            } else {
                res.setTags(new ArrayList<>());
            }
            if (history.getScores() != null && !history.getScores().isEmpty()) {
                res.setScores(objectMapper.readValue(history.getScores(), new TypeReference<List<String>>() {}));
            } else {
                res.setScores(new ArrayList<>());
            }
        } catch (Exception e) {
            res.setTags(new ArrayList<>());
            res.setScores(new ArrayList<>());
        }

        return res;
    }
}
