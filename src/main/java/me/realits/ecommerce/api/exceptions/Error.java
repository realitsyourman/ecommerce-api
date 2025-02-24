package me.realits.ecommerce.api.exceptions;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.util.Strings;

@Getter @Setter
public class Error implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  private String errorCode;
  private String message;
  private Integer status;
  private String url = "Not available";
  private String reqMethod = "Not available";

  public Error setUrl(String url) {
    if (Strings.isNotBlank(url)) {
      this.url = url;
    }
    return this;
  }

  public Error setReqMethod(String method) {
    if (Strings.isNotBlank(method)) {
      this.reqMethod = method;
    }
    return this;
  }

}
