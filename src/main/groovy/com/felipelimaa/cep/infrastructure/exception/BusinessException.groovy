package com.felipelimaa.cep.infrastructure.exception

import org.springframework.http.HttpStatus

class BusinessException extends Exception {

    final HttpStatus httpStatus
    final Throwable throwable

    BusinessException(String message, HttpStatus httpStatus) {
        super(message as String)
        this.httpStatus = httpStatus
    }

    BusinessException(String message, Throwable throwable, HttpStatus httpStatus) {
        super(message as String)
        this.httpStatus = httpStatus
        this.throwable = throwable
    }

}
