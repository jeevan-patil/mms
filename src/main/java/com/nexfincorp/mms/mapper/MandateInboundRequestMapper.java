package com.nexfincorp.mms.mapper;

import com.nexfincorp.mms.dto.enums.MandateRequestFileStatus;
import com.nexfincorp.mms.entity.MandateRequest;

public class MandateInboundRequestMapper {

  public static MandateRequest toMandateRequestEntity(final String fileName) {
    final MandateRequest request = new MandateRequest();
    request.setFileName(fileName);
    request.setStatus(MandateRequestFileStatus.NEW.name());
    request.setVersion(1L);
    return request;
  }
}
