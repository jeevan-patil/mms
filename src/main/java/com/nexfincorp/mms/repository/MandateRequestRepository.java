package com.nexfincorp.mms.repository;

import com.nexfincorp.mms.entity.MandateRequest;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MandateRequestRepository extends JpaRepository<MandateRequest, UUID> {

  Optional<MandateRequest> findByFileName(String fileName);
}