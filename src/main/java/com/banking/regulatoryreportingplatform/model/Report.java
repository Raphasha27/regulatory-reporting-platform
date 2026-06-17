package com.banking.regulatoryreportingplatform.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity @Table(name = "reports")
public class Report {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String reportType;
    private String frequency;
    private String format;
    private String status = "DRAFT";
    private String data;
    private LocalDateTime generatedAt;
    private LocalDateTime submittedAt;

    public Report() {}
    public Report(String name, String reportType, String frequency, String format) {
        this.name = name; this.reportType = reportType;
        this.frequency = frequency; this.format = format;
        this.generatedAt = LocalDateTime.now();
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getReportType() { return reportType; }
    public String getFrequency() { return frequency; }
    public String getFormat() { return format; }
    public String getStatus() { return status; }
    public String getData() { return data; }
    public LocalDateTime getGeneratedAt() { return generatedAt; }
    public LocalDateTime getSubmittedAt() { return submittedAt; }
    public void setStatus(String s) { this.status = s; }
    public void setData(String d) { this.data = d; }
    public void setSubmittedAt(LocalDateTime t) { this.submittedAt = t; }
}
