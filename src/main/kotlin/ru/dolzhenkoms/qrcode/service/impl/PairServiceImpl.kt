package ru.dolzhenkoms.qrcode.service.impl

import kotlin.jvm.optionals.getOrNull
import org.springframework.stereotype.Service
import ru.dolzhenkoms.qrcode.dto.CreatePairRequest
import ru.dolzhenkoms.qrcode.entity.Pair
import ru.dolzhenkoms.qrcode.repository.PairRepository
import ru.dolzhenkoms.qrcode.service.PairService
import java.time.LocalDateTime
import java.util.*

@Service
class PairServiceImpl(
    private val pairRepository: PairRepository
) : PairService {
    override fun getByPairId(pairId: String): Pair? {
        return pairRepository.findById(pairId).getOrNull()
    }

    override fun findAllActivePairs(): List<Pair> {
        val pairs = pairRepository.findAll()
        val now = LocalDateTime.now()

        return pairs
            .asSequence()
            .filterNotNull()
            .filter {
                it.endAt!!.isAfter(now) && it.startedAt!!.isBefore(now)
            }.toList()
    }

    override fun createNewPair(request: CreatePairRequest): String {
        val pairId = UUID.randomUUID().toString()
        val pair = Pair(
            id = pairId,
            lecturerId = request.lecturerId,
            startedAt = request.startedAt,
            endAt = request.endAt
        )

        pairRepository.save(pair)

        return pairId
    }

    override fun findAllActivePairsByLecturerId(lecturerId: String): List<String> {
        return findAllActivePairs()
            .filter { it.lecturerId == lecturerId }
            .mapNotNull {
                it.id
            }
    }
}