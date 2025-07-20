package com.nexfincorp.mms.repository;

import com.nexfincorp.mms.entity.Mandate;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MandateRepository extends JpaRepository<Mandate, UUID> {

    /**
     * Find mandates by status with pagination
     * @param status mandate status
     * @param pageable pagination parameters
     * @return page of mandates
     */
    Page<Mandate> findByStatus(String status, Pageable pageable);
}