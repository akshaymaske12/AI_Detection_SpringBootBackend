package com.truthlens.controller;

import com.truthlens.dto.ScanHistoryRequest;
import com.truthlens.dto.ScanHistoryResponse;
import com.truthlens.service.ScanHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/history")
public class ScanHistoryController {

    @Autowired
    private ScanHistoryService scanHistoryService;

    @PostMapping
    public ScanHistoryResponse saveScan(@RequestBody ScanHistoryRequest request) {
        return scanHistoryService.saveScan(request);
    }

    @GetMapping
    public List<ScanHistoryResponse> getHistory(@RequestParam String email) {
        return scanHistoryService.getUserHistory(email);
    }
}
