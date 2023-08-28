package com.taskconnect.serviceprovider.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class ApplicationErrorResponse {
    private final LocalDateTime timestamp;
    private String status;
    private List<String> messages;


    public ApplicationErrorResponse(HttpStatus status) {
        timestamp = LocalDateTime.now();
        this.status = status.toString();
    }

    public ApplicationErrorResponse(HttpStatus status, List<String> messages) {
        this(status);
        this.messages = messages;
    }

    public ApplicationErrorResponse(HttpStatus status, String message) {
        this(status);
        this.messages = Collections.singletonList(message);
    }
}
