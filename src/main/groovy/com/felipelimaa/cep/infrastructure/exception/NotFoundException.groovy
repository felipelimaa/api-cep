package com.felipelimaa.cep.infrastructure.exception

import org.springframework.http.HttpStatus

class NotFoundException extends BusinessException {

    NotFoundException(String msg) {
        super(msg, HttpStatus.NOT_FOUND)
    }

}
