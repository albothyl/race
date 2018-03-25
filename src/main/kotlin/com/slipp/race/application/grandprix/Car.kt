package com.slipp.race.application.grandprix

class Car(_name: String) {
    val name = _name
    var lap: Int = 0

    fun move(distance: Int) {
        if (distance > 4) {
            lap++
        }
    }
}
