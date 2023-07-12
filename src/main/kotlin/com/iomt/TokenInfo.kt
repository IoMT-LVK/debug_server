package com.iomt

import kotlinx.serialization.Serializable

@Serializable
data class TokenInfo(
    val token: String,
    val expires: String,
)
