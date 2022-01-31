package com.fcb.fcb.aiAssessment.controllers;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Responses {

    private String message;
    /**
     * field to check if its successful.
     */
    private boolean isSuccessful;
    /**
     * field for the time of response.
     */
    private LocalDateTime timeStamp;

    public Responses(String message) {
        this.message = message;
    }

    public Responses(String message, boolean isSuccessful) {
        this.message = message;
        this.isSuccessful = isSuccessful;
    }
}

