package ru.dolzhenkoms.qrcode.service

import ru.dolzhenkoms.qrcode.dto.CreatePairRequest
import ru.dolzhenkoms.qrcode.entity.Pair

interface PairService {
    fun getByPairId(pairId: String): Pair?

    fun findAllActivePairs(): List<Pair>

    fun createNewPair(request: CreatePairRequest): String

    fun findAllActivePairsByLecturerId(lecturerId: String): List<String>
}

