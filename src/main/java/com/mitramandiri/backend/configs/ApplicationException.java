package com.mitramandiri.backend.configs;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {
    HttpStatus status;

    public ApplicationException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
