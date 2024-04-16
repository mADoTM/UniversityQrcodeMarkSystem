package ru.dolzhenkoms.qrcode.service

interface PairSecretService {

    fun isSecretActual(secret: String, pairId: String): Boolean

    fun updateSecretByPair(pairId: String)

    fun getSecretByPairId(pairId: String): String?
}