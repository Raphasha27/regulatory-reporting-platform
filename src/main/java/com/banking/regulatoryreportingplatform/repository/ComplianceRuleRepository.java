package com.banking.regulatoryreportingplatform.repository;

import com.banking.regulatoryreportingplatform.model.ComplianceRule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComplianceRuleRepository extends JpaRepository<ComplianceRule, String> {
    List<ComplianceRule> findByActiveTrue();
    List<ComplianceRule> findByRegulation(String regulation);
}
