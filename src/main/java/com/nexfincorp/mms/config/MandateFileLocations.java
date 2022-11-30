package com.nexfincorp.mms.config;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MandateFileLocations {

  @Autowired
  private Environment env;

  @Bean(name = "mandateInboundDir")
  public File inboundDirectory() {
    return makeDirectory(env.getProperty("mandate.path.inbound"));
  }

  @Bean(name = "mandateProcessedDir")
  public File processedDirectory() {
    return makeDirectory(env.getProperty("mandate.path.processed"));
  }

  @Bean(name = "inboundFailedDirectory")
  public File failedDirectory() {
    return makeDirectory(env.getProperty("mandate.path.failed"));
  }

  @Bean(name = "mandateOutboundDir")
  public File outboundDirectory() {
    return makeDirectory(env.getProperty("mandate.path.outbound"));
  }

  private File makeDirectory(String path) {
    File file = new File(path);
    file.mkdirs();
    return file;
  }
}
