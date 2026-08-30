package com.truthlens.controller;

import com.truthlens.dto.DetectionResponse;
import com.truthlens.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/analysis")
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @PostMapping(value = "/detect", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public DetectionResponse detectMedia(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam(value = "type", defaultValue = "img") String type) {
        return analysisService.analyzeMedia(file, type);
    }
}
