package ru.dolzhenkoms.qrcode.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.util.UUID

@Entity
data class Note(
    @Id
    val id: String? = null,
    val studentId: String? = null,
    val pairId: String? = null,
    val markedAt: LocalDateTime? = null,
)