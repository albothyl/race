package com.slipp.race.application.grandprix

import com.slipp.race.`interface`.Race
import junit.framework.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class GrandPrixTest : Spek({

//    @Test
//    fun raceTest() {
        given("레이스") {
            val grandPrix = GrandPrix()
            var carList = "A,B,C,D"
            var finalLap = 10
            var race = Race(carList, finalLap)

//            on("레이스 등록") {
                val racerList = grandPrix.regist(race)
                val lap = grandPrix.finalLap

                it("finalLap과 참가자 목록 확인") {
                    assertEquals(10, lap)
                    assertEquals(4, racerList.size)
                }
//            }
        }
//    }
})