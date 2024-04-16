package ru.dolzhenkoms.qrcode.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.dolzhenkoms.qrcode.dto.MarkStudentOnPairRequest
import ru.dolzhenkoms.qrcode.dto.MarkedPairsResponse
import ru.dolzhenkoms.qrcode.dto.MarkedStudentsResponse
import ru.dolzhenkoms.qrcode.service.MarkStudentOnPairService
import ru.dolzhenkoms.qrcode.service.NoteService

@CrossOrigin
@RestController
@RequestMapping("api/v1/note")
class NoteController(
    private val noteService: NoteService,
    private val markStudentOnPairService: MarkStudentOnPairService
) {

    @GetMapping("/students/{pairId}")
    fun getAllStudents(@PathVariable pairId: String): ResponseEntity<MarkedStudentsResponse> {
        return ResponseEntity.ok(MarkedStudentsResponse(noteService.getAllStudentsByPairId(pairId)))
    }

    @GetMapping("/student/{studentId}")
    fun getNotedPairsByStudentId(@PathVariable studentId: String): ResponseEntity<MarkedPairsResponse> {
        return ResponseEntity.ok(MarkedPairsResponse(noteService.getAllPairsByStudentId(studentId)))
    }

    @PatchMapping
    fun tryMarkStudent(@RequestBody request: MarkStudentOnPairRequest): ResponseEntity<Any> {
        val result = markStudentOnPairService.execute(request)
        return if (result) ResponseEntity(HttpStatus.OK) else ResponseEntity(HttpStatus.BAD_REQUEST)
    }
}