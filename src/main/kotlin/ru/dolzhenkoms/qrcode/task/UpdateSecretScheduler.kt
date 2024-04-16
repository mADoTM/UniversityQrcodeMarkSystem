package ru.dolzhenkoms.qrcode.task

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import ru.dolzhenkoms.qrcode.service.PairSecretService
import ru.dolzhenkoms.qrcode.service.PairService

@Component
class UpdateSecretScheduler(
    private val pairSecretService: PairSecretService,
    private val pairService: PairService
) {

    @Async
    @Scheduled(cron = "\${secret-expiration.cron}")
    fun updateSecrets() = runBlocking {
        val activePairs = pairService.findAllActivePairs()

        activePairs.forEach {
            launch {
                pairSecretService.updateSecretByPair(it.id!!)
            }
        }
    }
}