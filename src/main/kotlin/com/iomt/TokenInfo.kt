package com.iomt

import kotlinx.serialization.Serializable

@Serializable
data class TokenInfo(
    val token: String,
    val expires: String,
) {
    companion object {
        val stub = TokenInfo("string", "2023-07-12T18:05:28.755Z")
    }
}
