package com.NLDM.JavaSpringBootNoSQL.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RoleException.class)
    public ResponseEntity<?> RoleExceptionHandler(RoleException roleException) {
        Map<String, String> ExceptionInfo = new HashMap<>();
        ExceptionInfo.put("Code", roleException.getCode());
        ExceptionInfo.put("Message", roleException.getMsg());
        return ResponseEntity.status(406).body(ExceptionInfo);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<?> UserExceptionHandler(UserException userException) {
        Map<String, String> ExceptionInfo = new HashMap<>();
        ExceptionInfo.put("Code", userException.getCode());
        ExceptionInfo.put("Message", userException.getMsg());
        return ResponseEntity.status(406).body(ExceptionInfo);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> UnknownException(Exception e) {
        Map<String, String> unknownException = new HashMap<>();
        unknownException.put("Code", "500");
        unknownException.put("Message", "Unknown Error");
        return ResponseEntity.status(500).body(unknownException);
    }
}
