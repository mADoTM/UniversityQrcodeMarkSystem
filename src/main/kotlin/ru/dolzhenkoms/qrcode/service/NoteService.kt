package ru.dolzhenkoms.qrcode.service

interface NoteService {
    fun getAllStudentsByPairId(pairId: String): List<String>

    fun getAllPairsByStudentId(studentId: String): List<String>

    fun markStudentOnPair(pairId: String, studentId: String)
}