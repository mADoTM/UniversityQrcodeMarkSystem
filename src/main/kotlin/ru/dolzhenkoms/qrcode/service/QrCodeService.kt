package ru.dolzhenkoms.qrcode.service

interface QrCodeService {
    fun generateQrCode(pairId: String): ByteArray

    fun generateQRCode(qrContent: String?, width: Int, height: Int): ByteArray
}
