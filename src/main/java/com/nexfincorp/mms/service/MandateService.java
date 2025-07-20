package com.nexfincorp.mms.service;

import com.nexfincorp.mms.dto.MandateResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MandateService {
    
    /**
     * Get paginated list of processed mandates
     * @param pageable pagination parameters
     * @return page of mandate responses
     */
    Page<MandateResponse> getProcessedMandates(Pageable pageable);
} 