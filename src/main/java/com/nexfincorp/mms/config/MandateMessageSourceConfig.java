package com.nexfincorp.mms.config;

import java.io.File;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.filters.CompositeFileListFilter;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;

@Log4j2
@Configuration
public class MandateMessageSourceConfig {

  @Value("${mandate.pattern.inbound}")
  private String mandateInboundFilePattern;

  @Autowired
  private MandateFileLocations mandateFileLocations;

  private CompositeFileListFilter<File> mandateFileFilterPattern() {
    final CompositeFileListFilter<File> filter = new CompositeFileListFilter<>();
    filter.addFilter(new SimplePatternFileListFilter(mandateInboundFilePattern));
    return filter;
  }

  @Bean
  @InboundChannelAdapter(value = "mandateInboundFileChannel", poller = @Poller(fixedDelay = "5000"))
  public FileReadingMessageSource fileReadingMessageSource() {
    log.info("Created mandate file inbound message channel");
    final FileReadingMessageSource reader = new FileReadingMessageSource();
    reader.setDirectory(mandateFileLocations.inboundDirectory());
    reader.setFilter(mandateFileFilterPattern());
    return reader;
  }

  @Bean
  @ServiceActivator(inputChannel = "mandateInboundFileChannel")
  public FileWritingMessageHandler fileWritingMessageHandler() {
    log.info("Created mandate file outbound message channel");
    final FileWritingMessageHandler writer = new FileWritingMessageHandler(
        mandateFileLocations.outboundDirectory());
    writer.setAutoCreateDirectory(true);
    writer.setExpectReply(false);
    return writer;
  }
}
