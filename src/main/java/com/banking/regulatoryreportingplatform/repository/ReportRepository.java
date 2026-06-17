package com.banking.regulatoryreportingplatform.repository;

import com.banking.regulatoryreportingplatform.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report, String> {
    List<Report> findByReportType(String reportType);
    List<Report> findByStatus(String status);
}
