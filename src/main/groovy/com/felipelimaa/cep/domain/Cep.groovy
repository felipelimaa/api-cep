package com.felipelimaa.cep.domain

import com.mashape.unirest.http.JsonNode
import org.json.JSONObject

class Cep {

    String cep
    String logradouro
    String complemento
    String bairro
    String localidade
    String uf
    String ibge
    String gia
    String ddd
    String siafi

    static Cep build(JSONObject json){
        def objectCep = [:]
        json.map.each { key, value ->
            objectCep[key] = value
        }
        Cep cep = new Cep(objectCep)
        cep
    }

}