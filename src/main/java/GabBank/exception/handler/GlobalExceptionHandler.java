package GabBank.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import GabBank.exception.custom.CpfAlreadyExistsException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CpfAlreadyExistsException.class)
    public ResponseEntity<String> handleCpfAlreadyExists(
        CpfAlreadyExistsException ex
    ) {

        return ResponseEntity
            .status(HttpStatus.CONFLICT)
            .body(ex.getMessage());
    }
}