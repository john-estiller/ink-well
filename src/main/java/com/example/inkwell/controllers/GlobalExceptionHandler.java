package com.example.inkwell.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.inkwell.exceptions.*;
import com.example.inkwell.utils.ResponseUtil;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ BadRequestException.class })
    public ResponseEntity<Map<String, Object>> handleStudentNotFoundException(BadRequestException exception) {
        return ResponseUtil.response(false, exception.getMessage());
    }
}
