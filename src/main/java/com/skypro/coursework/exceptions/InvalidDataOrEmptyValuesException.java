package com.skypro.coursework.exceptions;

public class InvalidDataOrEmptyValuesException extends RuntimeException {
    public InvalidDataOrEmptyValuesException(String massage) {
        super(massage);
    }
}
