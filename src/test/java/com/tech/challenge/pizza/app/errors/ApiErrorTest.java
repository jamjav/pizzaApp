package com.tech.challenge.pizza.app.errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ApiErrorTest {

    @Test
    public void testApiErrorConstructor() {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = "Bad Request";
        List<String> errors = Arrays.asList("Error 1", "Error 2");

        ApiError apiError = new ApiError(status, message, errors);

        Assertions.assertEquals(status, apiError.getStatus());
        Assertions.assertEquals(message, apiError.getMessage());
        Assertions.assertEquals(errors, apiError.getErrors());
    }

    @Test
    public void testApiErrorDefaultConstructor() {
        ApiError apiError = new ApiError();

        Assertions.assertNull(apiError.getStatus());
        Assertions.assertNull(apiError.getMessage());
        Assertions.assertNull(apiError.getErrors());
    }

    @Test
    public void testApiErrorSetters() {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = "Bad Request";
        List<String> errors = Arrays.asList("Error 1", "Error 2");

        ApiError apiError = new ApiError();
        apiError.setStatus(status);
        apiError.setMessage(message);
        apiError.setErrors(errors);

        Assertions.assertEquals(status, apiError.getStatus());
        Assertions.assertEquals(message, apiError.getMessage());
        Assertions.assertEquals(errors, apiError.getErrors());
    }
}