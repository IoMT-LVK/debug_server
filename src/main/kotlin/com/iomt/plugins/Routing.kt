package com.iomt.plugins

import com.iomt.DeviceConfig.Companion.deviceConfigs
import com.iomt.TokenInfo
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        post("/api/v1/auth/user") {
            call.respond(TokenInfo("string", "2023-07-12T18:05:28.755Z"))
        }

        get("/api/v1/device_types") {
            val prefix = context.parameters["name"].orEmpty()
            call.respond(deviceConfigs.filter { it.general.name.startsWith(prefix) })
        }
    }
}
