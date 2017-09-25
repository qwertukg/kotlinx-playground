package kz.qwertukg.ui

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class UiApplication

fun main(args: Array<String>) {
    SpringApplication.run(UiApplication::class.java, *args)
}
