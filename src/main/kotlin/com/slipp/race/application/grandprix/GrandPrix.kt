package com.slipp.race.application.grandprix

fun main(args: Array<String>) {
    val carList = readLine()!!
            .split(",")
            .asSequence()
            .map { carName -> Car(carName) }
            .toList()

    var finalLap = readLine()!!
            .toInt()
    
    val track = Track(carList, finalLap)
    val winner = track.race()

    println("winner is : ${winner.name}, lap : ${winner.lap}")
}