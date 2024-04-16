package ru.dolzhenkoms.qrcode

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
@ConfigurationPropertiesScan
class QrcodeApplication

fun main(args: Array<String>) {
    runApplication<QrcodeApplication>(*args)
}
