package no.norbay.testcontainers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundRestException extends RuntimeException {
    public NotFoundRestException() {
        super();
    }
    public NotFoundRestException(String message, Throwable cause) {
        super(message, cause);
    }
    public NotFoundRestException(String message) {
        super(message);
    }
    public NotFoundRestException(Throwable cause) {
        super(cause);
    }
}
