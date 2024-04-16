package ru.dolzhenkoms.qrcode.service.impl

import org.springframework.stereotype.Service
import ru.dolzhenkoms.qrcode.dto.MarkStudentOnPairRequest
import ru.dolzhenkoms.qrcode.service.MarkStudentOnPairService
import ru.dolzhenkoms.qrcode.service.NoteService
import ru.dolzhenkoms.qrcode.service.PairSecretService
import ru.dolzhenkoms.qrcode.service.PairService

@Service
class MarkStudentOnPairServiceImpl(
    private val pairSecretService: PairSecretService,
    private val noteService: NoteService,
) : MarkStudentOnPairService {
    override fun execute(request: MarkStudentOnPairRequest): Boolean {
        if (request.pairId == null || request.secret == null || request.studentId == null) {
            return false
        }
        if (pairSecretService.isSecretActual(request.secret, request.pairId)
            && !isStudentOnPair(request.studentId, request.pairId)
        ) {
            noteService.markStudentOnPair(request.pairId, request.studentId)
            return true
        }

        return false
    }

    private fun isStudentOnPair(studentId: String, pairId: String) =
        noteService.getAllStudentsByPairId(pairId).any { it == studentId }
}