package com.example.inkwell.utils;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ResponseUtilTests {

    @Test
    void testResponseSuccess() {
        List<String> testData = List.of("item1", "item2");
        ResponseEntity<Map<String, Object>> responseEntity = ResponseUtil.response(true, testData);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Map<String, Object> responseBody = responseEntity.getBody();
        assertNotNull(responseBody);
        assertEquals(true, responseBody.get("success"));
        assertEquals(testData, responseBody.get("response"));
    }

    @Test
    void testResponseFailure() {
        List<String> testData = List.of("error1", "error2");
        ResponseEntity<Map<String, Object>> responseEntity = ResponseUtil.response(false, testData);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        Map<String, Object> responseBody = responseEntity.getBody();
        assertNotNull(responseBody);
        assertEquals(false, responseBody.get("success"));
        assertEquals(testData, responseBody.get("response"));
    }
}
