package ru.dolzhenkoms.qrcode.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class PairSecret(
    @Id
    val id: String? = null,
    val pairId: String? = null,
    val secret: String? = null,
    val expirationAt: LocalDateTime? = null
)
