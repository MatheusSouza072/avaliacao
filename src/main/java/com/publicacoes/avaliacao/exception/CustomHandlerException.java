package com.publicacoes.avaliacao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomHandlerException extends Exception {

    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;
    private final Integer code;

    public CustomHandlerException(final HttpStatus httpStatus, final String message) {
        super(message);
        this.httpStatus = httpStatus;
        this.code = httpStatus.value();
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public Integer getCode() {
        return this.code;
    }
}

