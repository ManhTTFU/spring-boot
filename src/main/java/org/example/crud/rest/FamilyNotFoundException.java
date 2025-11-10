package org.example.crud.rest;

public class FamilyNotFoundException extends RuntimeException {
    public FamilyNotFoundException(String message) {
        super(message);
    }

    public FamilyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FamilyNotFoundException(Throwable cause) {
        super(cause);
    }
}
