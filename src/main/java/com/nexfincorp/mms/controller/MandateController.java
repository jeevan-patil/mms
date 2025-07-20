package com.nexfincorp.mms.controller;

import com.nexfincorp.mms.dto.MandateResponse;
import com.nexfincorp.mms.service.MandateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mandates")
@RequiredArgsConstructor
public class MandateController {
    
    private final MandateService mandateService;
    
    /**
     * Get paginated list of processed mandates
     * @param page page number (0-based, default: 0)
     * @param size page size (default: 20)
     * @param sortBy sort field (default: createdAt)
     * @param sortDir sort direction (asc/desc, default: desc)
     * @return paginated list of mandate responses
     */
    @GetMapping("/processed")
    public ResponseEntity<Page<MandateResponse>> getProcessedMandates(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir) {
        
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) 
            ? Sort.by(sortBy).ascending() 
            : Sort.by(sortBy).descending();
        
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<MandateResponse> mandates = mandateService.getProcessedMandates(pageable);
        
        return ResponseEntity.ok(mandates);
    }
} 