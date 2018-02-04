package com.slipp.race.grandprix

import java.util.*

class Track(_carList: List<Car>, _finalLap: Int) {
    private val carList = _carList
    private val finalLap = _finalLap
    private val random = Random()

    fun race(): Car {
        for (lap in 1 .. finalLap) {
            println("Lap (${lap}) ==================================")
            moveCars()
        }

        println("Finsh ====================================")

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
