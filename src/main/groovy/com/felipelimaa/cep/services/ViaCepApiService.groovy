package com.felipelimaa.cep.services

import com.felipelimaa.cep.domain.Cep
import com.felipelimaa.cep.domain.CepData
import com.felipelimaa.cep.infrastructure.InternalServerException
import com.felipelimaa.cep.infrastructure.exception.NotFoundException
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.JsonNode
import com.mashape.unirest.http.Unirest
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ViaCepApiService {

    private static SUCCESS_RANGE_CODE = 200..299
    private static CLIENT_RANGE_CODE = 400..499
    private static ERROR_RANGE_CODE = 500..599

    static final String PATH = "/{cep}/json"

    @Value('${viacep.api.url}')
    String viacepUrl

    Cep find(CepData data){
        String url = viacepUrl + PATH.replace("{cep}", data.cepNumber.toString())
        HttpResponse<JsonNode> response
        try {
            response = Unirest.get(url)
                .header("content-type", "application/json")
                .asJson()
        } catch (Throwable e) {
            throw new InternalServerException("Error while getting cep. Try it again.")
        }

        switch(response.status) {
            case { SUCCESS_RANGE_CODE.contains(it) }:
                return Cep.build(response.body.object)
            case { CLIENT_RANGE_CODE.contains(it) }:
                throw new NotFoundException("CEP not found.")
            case { ERROR_RANGE_CODE.contains(it) }:
                def exception = new Exception("Error while getting cep. httpStatus=${response.status}")
                throw exception
        }
    }

}
