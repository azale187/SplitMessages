package com.bsb.fms.bsbfmsmockservice

import com.github.tomakehurst.wiremock.core.Options
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import com.github.tomakehurst.wiremock.WireMockServer

class Application {

    static void main(String[] args) {
        Options options = new WireMockConfiguration().port(8089).usingFilesUnderClasspath("stubs")
        WireMockServer wireMockServer = new WireMockServer(options)
        wireMockServer.start()
    }
}