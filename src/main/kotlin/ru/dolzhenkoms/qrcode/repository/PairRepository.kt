package ru.dolzhenkoms.qrcode.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.dolzhenkoms.qrcode.entity.Pair

@Repository
interface PairRepository : JpaRepository<Pair, String>