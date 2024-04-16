package ru.dolzhenkoms.qrcode.dto

data class MarkStudentOnPairRequest(
    val studentId: String? = null,
    val pairId: String? = null,
    val secret: String? = null
)
