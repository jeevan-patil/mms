package com.nexfincorp.mms.repository;

import com.nexfincorp.mms.entity.Mandate;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MandateRepository extends JpaRepository<Mandate, UUID> {

}