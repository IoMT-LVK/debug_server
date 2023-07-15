package com.iomt

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) { json() }

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        post("/api/v1/auth/user") {
            call.respond(TokenInfo.stub)
        }

        get("/api/v1/device_types") {
            val prefix = context.parameters["name"].orEmpty()
            call.respond(DeviceConfig.deviceConfigs.filter { it.general.name.startsWith(prefix) })
        }
    }
}
