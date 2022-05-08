package io.hoon.springdb1.jdbc.repository.exception;

public class RuntimeDbException extends RuntimeException {

    public RuntimeDbException() {
    }

    public RuntimeDbException(String message) {
        super(message);
    }

    public RuntimeDbException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeDbException(Throwable cause) {
        super(cause);
    }

    public RuntimeDbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
