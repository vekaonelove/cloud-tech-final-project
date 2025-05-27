package com.app.shared.dto;

import com.app.shared.enums.PolicyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDto {
    private Long id;
    private String policyNumber;
    private PolicyType policyType;
}
