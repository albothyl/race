package com.slipp.race.application.grandprix

import com.slipp.race.application.support.repeat

class Car(val _name: String) {
    val name = _name
    var lap: Int = 0

    fun move(distance: Int) {
        if (distance > 4) {
            lap++
        }

        println("${name}'s distance : ${"-".repeat(lap)}")
    }
}
