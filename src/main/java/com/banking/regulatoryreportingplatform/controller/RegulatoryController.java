package com.banking.regulatoryreportingplatform.controller;

import com.banking.regulatoryreportingplatform.model.*;
import com.banking.regulatoryreportingplatform.service.RegulatoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class RegulatoryController {
    private final RegulatoryService service;

    public RegulatoryController(RegulatoryService service) { this.service = service; }

    @PostMapping("/reports")
    public ResponseEntity<Report> generateReport(@RequestBody Map<String, String> req) {
        return ResponseEntity.ok(service.generateReport(
            req.get("name"), req.get("reportType"),
            req.get("frequency"), req.get("format")));
    }

    @GetMapping("/reports")
    public ResponseEntity<List<Report>> getReports(@RequestParam(required = false) String status) {
        return ResponseEntity.ok(service.getReports(status));
    }

    @GetMapping("/reports/{id}")
    public ResponseEntity<Report> getReport(@PathVariable String id) {
        return ResponseEntity.ok(service.getReport(id));
    }

    @PostMapping("/reports/{id}/submit")
    public ResponseEntity<Report> submitReport(@PathVariable String id) {
        return ResponseEntity.ok(service.submitReport(id));
    }

    @PostMapping("/rules")
    public ResponseEntity<ComplianceRule> createRule(@RequestBody Map<String, String> req) {
        return ResponseEntity.ok(service.createRule(
            req.get("name"), req.get("regulation"),
            req.get("description"), req.get("severity")));
    }

    @GetMapping("/rules")
    public ResponseEntity<List<ComplianceRule>> getRules() {
        return ResponseEntity.ok(service.getRules());
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        return ResponseEntity.ok(Map.of("status", "UP", "service", "regulatory-reporting-platform"));
    }
}
