package com.nexfincorp.mms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MandateFileAlreadyPresentException extends RuntimeException {

  public MandateFileAlreadyPresentException(String message) {
    super(message);
  }
}
