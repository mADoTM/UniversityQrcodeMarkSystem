package ru.dolzhenkoms.qrcode.controller

import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.dolzhenkoms.qrcode.service.PairService
import ru.dolzhenkoms.qrcode.service.QrCodeService

@CrossOrigin
@RestController
@RequestMapping("api/v1/qr")
class QrcodeController(
    private val qrCodeService: QrCodeService,
    private val pairService: PairService
) {
    @GetMapping("/{lecturerId}/{pairId}")
    fun generateQrCode(@PathVariable pairId: String, @PathVariable lecturerId: String, response: HttpServletResponse) {
        val outputStream = response.outputStream

        if(pairService.getByPairId(pairId)?.lecturerId != lecturerId) {
            response.contentType = "application/json"
            outputStream.write("".toByteArray())
        } else {
            response.contentType = "image/png"
            val qrCode = qrCodeService.generateQrCode(pairId)
            outputStream.write(qrCode)
        }
    }
}