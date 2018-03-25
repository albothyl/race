package com.slipp.race.application.grandprix

import com.google.common.collect.Lists
import com.slipp.race.application.support.repeat
import java.util.*

class Track {
    private val carList = Lists.newArrayList<Car>()!!
    private val random = Random()
    private val result = Lists.newArrayList<String>()
    private var lap = 0

    fun regist(_carList: List<Car>) {
        carList.addAll(_carList)
    }

    fun race(): List<String> {
        result.add("Lap ($lap) ==================================")
        lap++

        moveCars()

        return result
    }

    private fun moveCars() {
        for (car in carList) {
            val distance = random.nextInt(9)
            car.move(distance)

            result.add("${car.name}'s distance : ${"-".repeat(car.lap)}")
        }
    }
}
