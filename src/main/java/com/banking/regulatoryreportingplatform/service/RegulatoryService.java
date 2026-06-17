package com.banking.regulatoryreportingplatform.service;

import com.banking.regulatoryreportingplatform.model.*;
import com.banking.regulatoryreportingplatform.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class RegulatoryService {
    private final ReportRepository reportRepo;
    private final ComplianceRuleRepository ruleRepo;

    public RegulatoryService(ReportRepository rr, ComplianceRuleRepository cr) {
        this.reportRepo = rr; this.ruleRepo = cr;
    }

    public Report generateReport(String name, String reportType, String frequency, String format) {
        Report report = new Report(name, reportType, frequency, format);
        report.setData("{\"reportId\":\"" + UUID.randomUUID() + "\",\"generatedAt\":\"" + LocalDateTime.now() + "\"}");
        report.setStatus("GENERATED");
        return reportRepo.save(report);
    }

    public Report submitReport(String reportId) {
        Report report = reportRepo.findById(reportId).orElseThrow();
        report.setStatus("SUBMITTED");
        report.setSubmittedAt(LocalDateTime.now());
        return reportRepo.save(report);
    }

    public ComplianceRule createRule(String name, String regulation, String description, String severity) {
        return ruleRepo.save(new ComplianceRule(name, regulation, description, severity));
    }

    public List<Report> getReports(String status) {
        return status != null ? reportRepo.findByStatus(status) : reportRepo.findAll();
    }

    public Report getReport(String id) { return reportRepo.findById(id).orElseThrow(); }

    public List<ComplianceRule> getRules() { return ruleRepo.findByActiveTrue(); }
}
