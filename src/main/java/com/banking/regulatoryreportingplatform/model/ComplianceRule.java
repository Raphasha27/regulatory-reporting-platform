package com.banking.regulatoryreportingplatform.model;

import jakarta.persistence.*;

@Entity @Table(name = "compliance_rules")
public class ComplianceRule {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String regulation;
    private String description;
    private String severity;
    private boolean active = true;

    public ComplianceRule() {}
    public ComplianceRule(String name, String regulation, String description, String severity) {
        this.name = name; this.regulation = regulation;
        this.description = description; this.severity = severity;
    }
    public String getId() { return id; }
    public String getName() { return name; }
    public String getRegulation() { return regulation; }
    public String getDescription() { return description; }
    public String getSeverity() { return severity; }
    public boolean isActive() { return active; }
    public void setActive(boolean a) { this.active = a; }
}
