package com.slipp.race.application.grandprix

import com.google.common.collect.Lists
import com.slipp.race.`interface`.Race
import org.springframework.stereotype.Service

@Service
class GrandPrix {
    val track = Track()
    val carList = Lists.newArrayList<Car>()!!
    var finalLap = 0L

    fun regist(race: Race): List<String> {
        finalLap = race.finalLap

        val racerList = race.racers.split(",")

        carList.addAll(racerList.asSequence()
                .map { racer -> Car(racer) }
                .toList())

        track.regist(carList)

        return racerList
    }

    fun race(): List<String> {
        val raceResult = Lists.newArrayList<String>()
        for (lap in 0 until finalLap) {
            raceResult.addAll(track.race())
        }

        return raceResult

//      return track.race() //Flux.repeat(n) 이 정상적으로 동작할 경우의 return
    }

    fun winner(): List<String> {
        val winner = carList
                .asSequence()
                .maxBy { car -> car.lap }!!

        val result = Lists.newArrayList<String>()
        result.add("Finish ===================================")
        result.add("Winner is ${winner.name}")

        return result
    }
}