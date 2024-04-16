package ru.dolzhenkoms.qrcode.dto

import java.time.LocalDateTime

data class CreatePairRequest(
    val lecturerId: String? = null,
    val startedAt: LocalDateTime? = null,
    val endAt: LocalDateTime? = null,
)

