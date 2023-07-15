package com.iomt

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.server.testing.*
import kotlin.test.*
import io.ktor.http.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            module()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }

    @Test
    fun testAuthEndpoint() = testApplication {
        application { module() }

        ContentNegotiation

        client.post("/api/v1/auth/user") {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }
            .apply {
                assertEquals(HttpStatusCode.OK, status)
                val tokenInfo: TokenInfo = Json.decodeFromString(bodyAsText())
                assertEquals(tokenInfo.token, "string")
            }
    }
}
