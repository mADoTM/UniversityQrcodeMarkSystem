package ru.dolzhenkoms.qrcode.service.impl

import kotlin.jvm.optionals.getOrNull
import org.springframework.stereotype.Service
import ru.dolzhenkoms.qrcode.entity.PairSecret
import ru.dolzhenkoms.qrcode.repository.PairRepository
import ru.dolzhenkoms.qrcode.repository.PairSecretRepository
import ru.dolzhenkoms.qrcode.service.PairSecretService
import ru.dolzhenkoms.qrcode.service.PairService
import java.time.LocalDateTime
import java.util.UUID

@Service
class PairSecretServiceImpl(
    private val pairSecretRepository: PairSecretRepository,
    private val pairService: PairService,
) : PairSecretService {
    override fun isSecretActual(secret: String, pairId: String): Boolean {
        val pairSecret = getSecretByPairId(pairId)
        return pairSecret == secret
                && LocalDateTime.now().isBefore(pairService.getByPairId(pairId)?.endAt)
                && getByPairId(pairId)?.expirationAt?.isBefore(LocalDateTime.now()) == true
    }

    override fun updateSecretByPair(pairId: String) {
        val pairSecret = pairSecretRepository.findByPairId(pairId)
        val newSecret = UUID.randomUUID().toString()
        if (pairSecret.isPresent) {
            val entity = pairSecret.get()

            val updatedEntity = entity.copy(
                secret = newSecret,
                expirationAt = LocalDateTime.now().plusSeconds(7L)
            )
            pairSecretRepository.save(updatedEntity)
        } else {
            pairSecretRepository.save(
                PairSecret(
                    id = UUID.randomUUID().toString(),
                    pairId = pairId,
                    newSecret,
                    expirationAt = LocalDateTime.now().plusSeconds(7L)
                )
            )
        }
    }

    override fun getSecretByPairId(pairId: String): String? {
        return getByPairId(pairId)?.secret
    }

    private fun getByPairId(pairId: String): PairSecret? {
        return pairSecretRepository.findByPairId(pairId).getOrNull()
    }

    companion object {
        const val EXPIRATION = 7L
    }
}