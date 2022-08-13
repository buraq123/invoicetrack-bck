package uk.co.coralsoftware.invoicetrack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNonExistUser(NotFoundException notFoundException){
        return new ResponseEntity<>("no user exists", HttpStatus.BAD_REQUEST);
    }
}
