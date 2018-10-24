package com.bsb.fms.bsbfmsmockservice

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.tomakehurst.wiremock.core.Options
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
//import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import com.github.tomakehurst.wiremock.WireMockServer

@SpringBootApplication
class Application {

    static void main(String[] args) {
        Options options = new WireMockConfiguration().port(8089).usingFilesUnderClasspath("stubs")
        WireMockServer wireMockServer = new WireMockServer(options)
//        SpringApplication.run(Application.class, args)
        wireMockServer.start()
    }

    @Bean(name = "objectMapper")
    ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper()
        mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true)
        mapper
    }
}