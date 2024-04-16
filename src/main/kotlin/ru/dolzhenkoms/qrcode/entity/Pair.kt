package ru.dolzhenkoms.qrcode.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class Pair(
    @Id
    val id: String? = null,
    val lecturerId: String? = null,
    val startedAt: LocalDateTime? = null,
    val endAt: LocalDateTime? = null,
    val pairName: String? = null
)