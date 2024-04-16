package exchange.myfriendsbirthdays.extension;


import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class FriendExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(ConstraintViolationException ex) {
        // Убрал путь из сообщения.
        String message = ex.getMessage().split(":")[1].trim();
        return ResponseEntity.badRequest().body(buildErrorMap(message, HttpStatus.BAD_REQUEST));
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(NotFoundException ex) {
        return ResponseEntity.badRequest().body(buildErrorMap(ex.getMessage(), HttpStatus.NOT_FOUND));
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String errorMessage = "Incorrect date: " + ex.getValue() + ". Date must be 'yyyy-MM-dd' format ";
        return ResponseEntity.badRequest().body(buildErrorMap(errorMessage, HttpStatus.BAD_REQUEST));
    }


    private Map<String, Object> buildErrorMap(String message, HttpStatus code) {
        Map<String, Object> errors = new HashMap<>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        errors.put("timeStamp", timestamp.toString());
        errors.put("message", message);
        errors.put("code", code.value());
        return errors;

    }
}
