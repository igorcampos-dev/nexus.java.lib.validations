package com.nexus.validations.exceptions;

public class LargePasswordException extends RuntimeException {
    public LargePasswordException(String s) {
        super(s);
    }
}
