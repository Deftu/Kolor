package dev.deftu.kolor.test

import dev.deftu.kolor.Color
import dev.deftu.kolor.Kolor.parseHex
import dev.deftu.kolor.NamedColors.findClosestNamedColor
import dev.deftu.kolor.toAwt
import kotlin.test.Test

class AwtTest {

    @Test
    fun test() {
        val color: Color = parseHex("#CC3F3F")
        println(color)
        println(color.name)

        val closest = findClosestNamedColor(color)
        println(closest)
        println(closest.name)

        val awtColor = color.toAwt()
        println(awtColor)

        val awtClosest = closest.toAwt()
        println(awtClosest)
    }

}
