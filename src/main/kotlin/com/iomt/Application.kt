package com.iomt

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import com.iomt.plugins.*
import kotlinx.serialization.SerialName

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSecurity()
    configureSerialization()
    configureRouting()
}
