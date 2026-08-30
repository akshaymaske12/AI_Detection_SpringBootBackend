package com.truthlens.repository;

import com.truthlens.entity.ScanHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ScanHistoryRepository extends JpaRepository<ScanHistory, Long> {

    List<ScanHistory> findByUserEmailOrderByCreatedAtDesc(String userEmail);

}
