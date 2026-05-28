package com.example.it211_session12_bai4.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleStudentNotFound(
            StudentNotFoundException ex
    ) {

        log.warn("Lỗi không tìm thấy sinh viên: {}", ex.getMessage());

        Map<String, Object> response = new HashMap<>();

        response.put("error", ex.getMessage());
        response.put("status", 404);

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(
            Exception ex
    ) {

        log.error("Lỗi hệ thống: ", ex);

        Map<String, Object> response = new HashMap<>();

        response.put("error", "Đã xảy ra lỗi hệ thống");
        response.put("status", 500);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
