package com.nexfincorp.mms.mapper;

import com.nexfincorp.mms.dto.MandateResponse;
import com.nexfincorp.mms.dto.enums.MandateFrequency;
import com.nexfincorp.mms.dto.enums.MandateStatus;
import com.nexfincorp.mms.entity.Mandate;
import org.springframework.stereotype.Component;

@Component
public class MandateResponseMapper {
    
    public MandateResponse toResponse(Mandate mandate) {
        if (mandate == null) {
            return null;
        }
        
        MandateResponse response = new MandateResponse();
        response.setId(mandate.getId());
        response.setRequestId(mandate.getRequestId());
        response.setFromAccount(mandate.getFromAccount());
        response.setToAccount(mandate.getToAccount());
        response.setFrequency(MandateFrequency.valueOf(mandate.getFrequency()));
        response.setStartDate(mandate.getStartDate());
        response.setStatus(MandateStatus.valueOf(mandate.getStatus()));
        response.setCreatedAt(mandate.getCreatedDt());
        response.setUpdatedAt(mandate.getUpdatedDt());
        
        return response;
    }
} 