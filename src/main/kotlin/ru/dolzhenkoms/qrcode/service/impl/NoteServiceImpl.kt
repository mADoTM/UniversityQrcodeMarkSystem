package ru.dolzhenkoms.qrcode.service.impl

import org.springframework.stereotype.Service
import ru.dolzhenkoms.qrcode.entity.Note
import ru.dolzhenkoms.qrcode.repository.NoteRepository
import ru.dolzhenkoms.qrcode.service.NoteService
import java.time.LocalDateTime
import java.util.UUID

@Service
class NoteServiceImpl(
    private val noteRepository: NoteRepository,
) : NoteService {
    override fun getAllStudentsByPairId(pairId: String): List<String> {
        return noteRepository.findAllStudentsByPairId(pairId)
    }

    override fun getAllPairsByStudentId(studentId: String): List<String> {
        return noteRepository.findAllPairsByStudentId(studentId)
    }

    override fun markStudentOnPair(pairId: String, studentId: String) {
        val note = Note(
            id = UUID.randomUUID().toString(),
            studentId = studentId,
            pairId = pairId,
            markedAt = LocalDateTime.now()
        )

        noteRepository.save(note)
    }
}