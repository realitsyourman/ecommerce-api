package me.realits.ecommerce.api.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ErrorUtils {

  public static Error createError(final String errMsgKey, final String errorCode,
      final Integer httpStatusCode) {

    Error error = new Error();
    error.setMessage(errMsgKey);
    error.setErrorCode(errorCode);
    error.setStatus(httpStatusCode);

    return error;
  }
}
