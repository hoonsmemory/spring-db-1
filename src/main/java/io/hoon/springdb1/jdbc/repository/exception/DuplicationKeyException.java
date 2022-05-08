package io.hoon.springdb1.jdbc.repository.exception;

public class DuplicationKeyException extends RuntimeDbException {

    public DuplicationKeyException() {
    }

    public DuplicationKeyException(String message) {
        super(message);
    }

    public DuplicationKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicationKeyException(Throwable cause) {
        super(cause);
    }

    public DuplicationKeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
