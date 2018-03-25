package com.slipp.race.application.grandprix

import com.google.common.collect.Lists
import com.slipp.race.application.support.repeat
import java.util.*

class Track(_carList: List<Car>, _finalLap: Int) {
    private val carList = _carList
    private val finalLap = _finalLap
    private val random = Random()
    private val result = Lists.newArrayList<String>()

    fun race(): List<String> {
        for (lap in 0 until finalLap) {
            result.add("Lap ($lap) ==================================")
            moveCars()
        }

        result.add("Finish ===================================")

        winner()

        return result
    }

    private fun moveCars() {
        for (car in carList) {
            val distance = random.nextInt(9)
            car.move(distance)
            result.add("${car.name}'s distance : ${"-".repeat(car.lap)}")
        }
    }

    private fun winner() {
        val winner = carList
                .asSequence()
                .maxBy { car -> car.lap }!!

        result.add("\nwinner is ${winner.name}")
    }
}
