package exchange.myfriendsbirthdays.extension;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class FriendExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String,String>> handleValidationErrors(ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", ex.getMessage().split(":")[1].trim());
        errors.put("status", "400");
        return ResponseEntity.badRequest().body(errors);
    }
}
