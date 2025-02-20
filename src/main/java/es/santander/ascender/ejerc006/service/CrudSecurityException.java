package es.santander.ascender.ejerc006.service;

import java.io.Serial;
import java.util.Objects;

public class CrudSecurityException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    private final CRUDOperation operation;
    private final Long id;

    public CrudSecurityException(CRUDOperation operation, Long id) {
        this.operation = Objects.requireNonNull(operation, "Operation cannot be null");
        this.id = Objects.requireNonNull(id, "ID cannot be null");
    }

    public CrudSecurityException(String message, CRUDOperation operation, Long id) {
        super(message);
        this.operation = Objects.requireNonNull(operation, "Operation cannot be null");
        this.id = Objects.requireNonNull(id, "ID cannot be null");
    }

    public CrudSecurityException(String message, Throwable cause, CRUDOperation operation, Long id) {
        super(message, cause);
        this.operation = Objects.requireNonNull(operation, "Operation cannot be null");
        this.id = Objects.requireNonNull(id, "ID cannot be null");
    }

    public CrudSecurityException(String message, Throwable cause) {
        super(message, cause);
        this.operation = null;
        this.id = null;
    }

    public CRUDOperation getOperation() {
        return operation;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("CrudSecurityException { operation=%s, id=%d, message=%s }",
                operation, id, getMessage());
    }
}
