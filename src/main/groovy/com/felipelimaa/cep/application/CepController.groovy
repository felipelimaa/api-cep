package com.felipelimaa.cep.application

import com.felipelimaa.cep.domain.Cep
import com.felipelimaa.cep.domain.CepData
import com.felipelimaa.cep.services.ViaCepApiService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin
@CompileStatic
class CepController {

    @Autowired
    ViaCepApiService viaCepApiService

    @PostMapping("/v1/cep")
    Cep find(@RequestBody CepData cepData) {
        viaCepApiService.find(cepData)
    }
}
