package com.nexfincorp.mms.dto;

import com.nexfincorp.mms.dto.enums.MandateStatus;
import com.nexfincorp.mms.dto.enums.MandateFrequency;
import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Data
public class MandateResponse {
    private UUID id;
    private String requestId;
    private String fromAccount;
    private String toAccount;
    private MandateFrequency frequency;
    private Date startDate;
    private MandateStatus status;
    private Date createdAt;
    private Date updatedAt;
} 