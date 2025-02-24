package me.realits.ecommerce.api.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class RestApiErrorHandler {

  private final MessageSource messageSource;

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Error> handlerException(HttpServletRequest request, Exception ex,
      Locale locale) {

    Error error = ErrorUtils.createError(ErrorCode.GENERIC_ERROR.getErrMsgKey(),
            ErrorCode.GENERIC_ERROR.getErrCode(), HttpStatus.INTERNAL_SERVER_ERROR.value())
        .setUrl(request.getRequestURL().toString())
        .setReqMethod(request.getMethod());

    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
  public ResponseEntity<Error> handleHttpMediaTypeNotSupportedException(HttpServletRequest request,
      HttpMediaTypeNotSupportedException ex, Local local) {

    Error error = ErrorUtils
        .createError(ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getErrMsgKey(),
            ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getErrCode(),
            HttpStatus.UNSUPPORTED_MEDIA_TYPE.value())
        .setUrl(request.getRequestURL().toString())
        .setReqMethod(request.getMethod());

    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
