package com.nexfincorp.mms.entity;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MandateRequestRepository extends JpaRepository<MandateRequest, UUID> {

}