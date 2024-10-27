package com.example.inkwell.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

public class ResponseUtil {
    public static ResponseEntity<Map<String, Object>> response(boolean success, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", success);
        response.put("response", data);
        HttpStatus statusCode = success ? HttpStatus.OK : HttpStatus.BAD_REQUEST;

        return new ResponseEntity<Map<String, Object>>(response, statusCode);
    }
}