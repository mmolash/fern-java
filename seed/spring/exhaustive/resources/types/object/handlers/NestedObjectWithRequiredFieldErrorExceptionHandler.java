/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.types.object.handlers;

import java.lang.Object;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import resources.types.object.exceptions.NestedObjectWithRequiredFieldError;

@RestControllerAdvice
public final class NestedObjectWithRequiredFieldErrorExceptionHandler {
  @ExceptionHandler(NestedObjectWithRequiredFieldError.class)
  ResponseEntity<Object> handle(
      NestedObjectWithRequiredFieldError nestedObjectWithRequiredFieldError) {
    return new ResponseEntity<>(nestedObjectWithRequiredFieldError.getBody(), null, NestedObjectWithRequiredFieldError.STATUS_CODE);
  }
}