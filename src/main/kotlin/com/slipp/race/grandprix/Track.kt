package com.slipp.race.grandprix

import java.util.*

class Track(_carList: List<Car>, _finalLap: Int) {
    private val carList = _carList
    private val finalLap = _finalLap
    private val random = Random()

    fun race(): Car {
        for (lap in 0 until finalLap) {
            println("Lap ($lap) ==================================")
            moveCars()
        }

        println("Finish ===================================")

        return carList
                .asSequence()
                .maxBy { car -> car.lap }!!
    }

    private fun moveCars() {
        for (car in carList) {
            val distance = random.nextInt(9)
            car.move(distance)
        }
    }
}
