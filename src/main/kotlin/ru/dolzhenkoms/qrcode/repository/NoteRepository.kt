package ru.dolzhenkoms.qrcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import ru.dolzhenkoms.qrcode.entity.Note

@Repository
interface NoteRepository : JpaRepository<Note, String> {
    @Query(
        nativeQuery = true,
        value = """
            select student_id
            from marks.public.note
            where pair_id = :pairId
        """
    )
    fun findAllStudentsByPairId(pairId: String): List<String>

    @Query(
        nativeQuery = true,
        value = """
            select pair_name
            from marks.public.note
            where student_id = :studentId
        """
    )
    fun findAllPairsByStudentId(studentId: String): List<String>
}

