package com.nexfincorp.mms.mapper;

import com.nexfincorp.mms.dto.MandateInboundFileResponse;
import com.nexfincorp.mms.entity.MandateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MandateInboundFileResponseMapper {

  MandateInboundFileResponseMapper INSTANCE = Mappers.getMapper(
      MandateInboundFileResponseMapper.class);

  @Mappings({
      @Mapping(target = "uuid", source = "id")
  })
  MandateInboundFileResponse mapToResponse(MandateRequest mandateRequest);
}
