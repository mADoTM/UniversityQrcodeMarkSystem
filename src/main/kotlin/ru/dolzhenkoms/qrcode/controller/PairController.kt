package ru.dolzhenkoms.qrcode.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.dolzhenkoms.qrcode.dto.AllPairsByLecturerIdResponse
import ru.dolzhenkoms.qrcode.dto.CreatePairRequest
import ru.dolzhenkoms.qrcode.dto.CreatePairResponse
import ru.dolzhenkoms.qrcode.service.PairService

@CrossOrigin
@RestController
@RequestMapping("api/v1/pair")
class PairController(
    private val pairService: PairService
) {

    @GetMapping("/{lecturerId}")
    fun getAllPairsByLecturerId(@PathVariable("lecturerId") lecturerId: String): ResponseEntity<AllPairsByLecturerIdResponse> {
        return ResponseEntity.ok(
            AllPairsByLecturerIdResponse(pairService.findAllActivePairsByLecturerId(lecturerId))
        )
    }

    @PostMapping
    fun createNewPair(@RequestBody request: CreatePairRequest): ResponseEntity<CreatePairResponse> {
        val pairId = pairService.createNewPair(request)
        return ResponseEntity.ok(CreatePairResponse(pairId))
    }
}

