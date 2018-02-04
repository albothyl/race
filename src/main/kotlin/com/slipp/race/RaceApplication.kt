package com.slipp.race

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RaceApplication

fun main(args: Array<String>) {
    runApplication<RaceApplication>(*args)
}
