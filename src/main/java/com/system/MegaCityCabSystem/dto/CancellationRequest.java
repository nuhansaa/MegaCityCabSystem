package com.system.MegaCityCabSystem.dto;

import lombok.Data;

@Data
public class CancellationRequest {
    
    private String bookingId;
    private String reason;
}
