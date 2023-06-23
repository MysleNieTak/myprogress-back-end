package com.pp.myprogress.exception;

public class IllegalValueException extends RuntimeException {
    public IllegalValueException(String name) {
        super("Incorrect value of the: " + name);
    }
}
