package com.app.shared.dto;

import com.app.shared.enums.ClaimStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimDto {
    private Long id;
    private Long userId;
    private Long policyId;
    private LocalDate claimDate;
    private ClaimStatus status;
}
