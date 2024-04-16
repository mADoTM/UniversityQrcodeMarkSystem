package ru.dolzhenkoms.qrcode.service

import ru.dolzhenkoms.qrcode.dto.MarkStudentOnPairRequest

interface MarkStudentOnPairService {

    fun execute(request: MarkStudentOnPairRequest): Boolean
}