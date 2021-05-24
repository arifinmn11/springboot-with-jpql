package com.mitramandiri.backend.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseMessage<T> {
    private int code;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    private ResponseMessage(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> ResponseMessage<T> success(T data) {
        return new ResponseMessage<>(HttpStatus.OK.value(), null, data);
    }

    public static ResponseMessage error(HttpStatus httpStatus) {
        return error(httpStatus.value(), httpStatus.getReasonPhrase(), null);
    }

    public static ResponseMessage error(int code, String message) {
        return error(code, message, null);
    }

    public static <T> ResponseMessage<T> error(int code, String message, T data) {
        return new ResponseMessage<>(code, message, data);
    }

}
