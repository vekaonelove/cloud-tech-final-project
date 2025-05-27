package com.app.shared.message;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimSubmittedMessage implements Serializable {
    private Long claimId;
    private Long userId;
    private String claimType;
    private String status;
}
