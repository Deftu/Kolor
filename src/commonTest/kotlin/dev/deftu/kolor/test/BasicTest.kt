package dev.deftu.kolor.test

import dev.deftu.kolor.Color
import dev.deftu.kolor.Kolor.parseHex
import dev.deftu.kolor.NamedColors.findClosestNamedColor
import kotlin.test.Test

class BasicTest {

    @Test
    fun test() {
        val color: Color = parseHex("#CC3F3F")
        println(color)
        println(color.name)

        val closest = findClosestNamedColor(color)
        println(closest)
        println(closest.name)
    }

}
