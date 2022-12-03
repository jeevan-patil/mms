package com.nexfincorp.mms.service;

import com.nexfincorp.mms.dto.MandateInboundFileResponse;

public interface MandateInboundFileService {

  MandateInboundFileResponse process(String fileName);
}
