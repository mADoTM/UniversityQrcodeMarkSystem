package ru.dolzhenkoms.qrcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.dolzhenkoms.qrcode.entity.PairSecret
import java.util.Optional

@Repository
interface PairSecretRepository : JpaRepository<PairSecret, String> {
    fun findByPairId(pairId: String): Optional<PairSecret>

}