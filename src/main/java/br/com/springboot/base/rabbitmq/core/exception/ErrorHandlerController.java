package br.com.springboot.base.rabbitmq.core.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(ErrorApiException.class)
    public final ResponseEntity<ErrorApiResponse> handler(final ErrorApiException exception){
        log.warn("Warning: " + exception.getErrorApiResponse().getMessage());
        return new ResponseEntity<>(
                exception.getErrorApiResponse(),
                exception.getHttpStatus()
        );
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorApiResponse> handler(final Exception exception){
        log.warn("Warning: " + exception.toString());
        return new ResponseEntity(
                ErrorApiResponse.builder()
                        .message(exception.getMessage())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}
