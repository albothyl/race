package com.slipp.race.application.grandprix

import com.google.common.collect.Lists
import com.slipp.race.`interface`.Race
import org.springframework.stereotype.Service

@Service
class GrandPrix {
    val carList = Lists.newArrayList<Car>()!!
    var finalLap = 0

    fun regist(race: Race): List<String> {
        finalLap = race.finalLap

        val racerList = race.racers.split(",")

        carList.addAll(racerList.asSequence()
                .map { racer -> Car(racer) }
                .toList())

//        println("===== racerList : ${racerList}")

        return racerList
    }

    fun race(finalLap: Int): Car {
        return Track(carList, finalLap).race()
    }
}