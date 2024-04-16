package ru.dolzhenkoms.qrcode.service.impl

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.CrossOrigin
import ru.dolzhenkoms.qrcode.service.PairSecretService
import ru.dolzhenkoms.qrcode.service.QrCodeService
import java.io.ByteArrayOutputStream

@CrossOrigin
@Service
class QrCodeServiceImpl(
    private val pairSecretService: PairSecretService,
    private val objectMapper: ObjectMapper
) : QrCodeService {
    override fun generateQrCode(pairId: String): ByteArray {
        val secret = pairSecretService.getSecretByPairId(pairId)
        val content = objectMapper.writeValueAsString(generateContent(pairId, secret))
        return generateQRCode(content, WIDTH, HEIGHT)
    }

    override fun generateQRCode(qrContent: String?, width: Int, height: Int): ByteArray {
        val qrCodeWriter = QRCodeWriter()
        val bitMatrix = qrCodeWriter.encode(qrContent, BarcodeFormat.QR_CODE, width, height)
        val byteArrayOutputStream = ByteArrayOutputStream()
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream)
        return byteArrayOutputStream.toByteArray()
    }

    private fun generateContent(pairId: String, secret: String?) =
        mapOf("pairId" to pairId, "secret" to secret)

    companion object {
        const val WIDTH = 800
        const val HEIGHT = 800
    }
}