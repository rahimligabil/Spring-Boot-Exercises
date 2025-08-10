package com.gabil.deneme1.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum MessageType {
    STUDENT_NOT_FOUND("Student not found."),
    INVALID_INPUT("Invalid input provided."),
    GENERAL_ERROR("Something went wrong!");

    private final String message;
}