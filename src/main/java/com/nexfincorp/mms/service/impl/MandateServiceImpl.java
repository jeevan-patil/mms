package com.nexfincorp.mms.service.impl;

import com.nexfincorp.mms.dto.MandateResponse;
import com.nexfincorp.mms.dto.enums.MandateStatus;
import com.nexfincorp.mms.entity.Mandate;
import com.nexfincorp.mms.mapper.MandateResponseMapper;
import com.nexfincorp.mms.repository.MandateRepository;
import com.nexfincorp.mms.service.MandateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MandateServiceImpl implements MandateService {
    
    private final MandateRepository mandateRepository;
    private final MandateResponseMapper mandateResponseMapper;
    
    @Override
    public Page<MandateResponse> getProcessedMandates(Pageable pageable) {
        Page<Mandate> mandates = mandateRepository.findByStatus(
            MandateStatus.ACTIVE.name(), 
            pageable
        );
        
        return mandates.map(mandateResponseMapper::toResponse);
    }
} 