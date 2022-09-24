package com.felipelimaa.cep.infrastructure

import com.felipelimaa.cep.infrastructure.exception.BusinessException
import org.springframework.http.HttpStatus

class InternalServerException extends BusinessException {

    InternalServerException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR)
    }

}
