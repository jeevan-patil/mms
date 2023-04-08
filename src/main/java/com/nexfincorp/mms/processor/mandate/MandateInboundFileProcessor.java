package com.nexfincorp.mms.processor.mandate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexfincorp.mms.config.MandateFileLocations;
import com.nexfincorp.mms.dto.MandateInboundFileResponse;
import com.nexfincorp.mms.service.MandateInboundFileService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component(value = "mandateInboundFileProcessor")
public class MandateInboundFileProcessor {

  @Autowired
  private MandateFileLocations mandateFileLocations;

  @Autowired
  private MandateInboundFileService mandateInboundFileService;

  @Autowired
  private ObjectMapper objectMapper;

  public String process(final Message<File> inboundFile) {
    final String fileName = inboundFile.getPayload().getName();
    log.info("Received mandate file : " + fileName);

    final String fileNameWithPath = Objects.requireNonNull(
        inboundFile.getHeaders().get("file_originalFile")).toString();
    final Path inboundFilePath = Paths.get(fileNameWithPath);

    try {
      final MandateInboundFileResponse response = mandateInboundFileService.process(fileName);

      Files.move(inboundFilePath,
          Paths.get(mandateFileLocations.processedDirectory() + "/" + fileName));
      log.info("Moved " + fileName + " to processed directory");

      return objectMapper.writeValueAsString(response);
    } catch (Exception e) {
      log.error("Exception occurred while moving file to processed directory.", e);
      try {
        Files.move(inboundFilePath,
            Paths.get(mandateFileLocations.failedDirectory() + "/" + fileName),
            StandardCopyOption.REPLACE_EXISTING);
      } catch (IOException ex) {
        log.error("Could not move file {} to the error directory", fileName);
      }
    }

    return inboundFile.getPayload().getName();
  }
}
