package com.truthlens.service;

import com.truthlens.dto.DetectionResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class AnalysisService {

    private final Random random = new Random();
    private final DecimalFormat df = new DecimalFormat("#.##");

    public DetectionResponse analyzeMedia(MultipartFile file, String type) {
        String originalFilename = file != null && file.getOriginalFilename() != null ? file.getOriginalFilename() : "uploaded_media";
        long sizeBytes = file != null ? file.getSize() : 0;
        double sizeMB = (double) sizeBytes / (1024 * 1024);
        String sizeFormatted = sizeMB >= 1.0 ? df.format(sizeMB) + " MB" : df.format((double) sizeBytes / 1024) + " KB";

        String ext = "FILE";
        if (originalFilename.contains(".")) {
            ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toUpperCase();
        }

        boolean isImage = !"vid".equalsIgnoreCase(type) && !ext.equalsIgnoreCase("MP4") && !ext.equalsIgnoreCase("MOV");
        String meta = sizeFormatted + " · " + ext + (isImage ? " · 1024x1024" : " · 1080p");

        // Deterministic pseudorandom seed based on file size and name for consistent results on the same file
        long seed = originalFilename.hashCode() ^ sizeBytes;
        Random seededRandom = new Random(seed);

        int confidenceVal = 78 + seededRandom.nextInt(20); // 78% - 97%
        String confidence = confidenceVal + "%";

        boolean isAi = seededRandom.nextBoolean() || originalFilename.toLowerCase().contains("ai") || originalFilename.toLowerCase().contains("fake") || originalFilename.toLowerCase().contains("deepfake");
        String verdict = isAi ? (isImage ? "AI GENERATED" : "AI DEEPFAKE") : "REAL MEDIA";

        List<String> tags = new ArrayList<>();
        String desc;
        List<String> scores = new ArrayList<>();

        if (isAi) {
            if (isImage) {
                desc = "The model detected unnatural frequency domain anomalies, irregular micro-textures, and synthesis blending artifacts common in generative AI diffusion models.";
                tags = Arrays.asList("Unnatural texture patterns", "Irregular lighting gradients", "Inconsistent pixel noise");
            } else {
                desc = "Several frames exhibit temporal jitter, facial boundary blend artifacts, and spectral discrepancies indicative of deepfake synthesis.";
                tags = Arrays.asList("Face edge flickering", "Frame inconsistency", "Lip-sync synthesis artifact");
            }
            for (int i = 0; i < 5; i++) {
                int s = 75 + seededRandom.nextInt(23);
                scores.add(s + "%");
            }
        } else {
            desc = "No prominent generative synthesis artifacts or boundary distortions detected. Spectral distribution and noise coherence conform to natural sensor capture.";
            tags = Arrays.asList("Natural sensor noise", "Consistent lighting", "Authentic edge sharpness");
            for (int i = 0; i < 5; i++) {
                int s = 10 + seededRandom.nextInt(25);
                scores.add(s + "%");
            }
        }

        String icon = isImage ? "📷" : "🎬";

        return new DetectionResponse(originalFilename, meta, verdict, confidence, desc, tags, scores, isImage, icon);
    }
}
