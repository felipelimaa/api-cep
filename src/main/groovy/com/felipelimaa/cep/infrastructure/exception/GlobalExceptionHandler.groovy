package com.felipelimaa.cep.infrastructure.exception

import com.felipelimaa.cep.infrastructure.ErrorResponse
import com.felipelimaa.cep.infrastructure.InternalServerException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException)
    ResponseEntity handleNotFound(NotFoundException notFoundException) {
        ResponseEntity.status(notFoundException.httpStatus)
            .body(new ErrorResponse(message: notFoundException.message))
    }

    @ExceptionHandler(InternalServerException)
    ResponseEntity handleInternalServerException(InternalServerException internalServerException) {
        ResponseEntity.status(internalServerException.httpStatus)
            .body(new ErrorResponse(message: internalServerException.message))
    }

}
