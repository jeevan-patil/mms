package com.nexfincorp.mms.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexfincorp.mms.dto.MandateInboundFileResponse;
import com.nexfincorp.mms.entity.MandateRequest;
import com.nexfincorp.mms.entity.MandateRequestRepository;
import com.nexfincorp.mms.mapper.MandateInboundFileResponseMapper;
import com.nexfincorp.mms.mapper.MandateInboundRequestMapper;
import com.nexfincorp.mms.service.MandateInboundFileService;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Log4j2
@Service
public class MandateInboundFileServiceImpl implements MandateInboundFileService {

  @Autowired
  public MandateRequestRepository mandateRequestRepository;

  @Autowired
  public ObjectMapper objectMapper;

  @Override
  @Transactional(value = TxType.REQUIRED, rollbackOn = Exception.class)
  public MandateInboundFileResponse process(final String fileName) {
    final MandateRequest mandateRequest = MandateInboundRequestMapper.toMandateRequestEntity(
        fileName);
    mandateRequestRepository.save(mandateRequest);
    log.info("Mandate request entry create for file {}", fileName);
    return MandateInboundFileResponseMapper.INSTANCE.mapToResponse(mandateRequest);
  }
}
