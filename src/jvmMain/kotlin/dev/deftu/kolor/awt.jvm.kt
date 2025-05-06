@file:JvmName("KolorAwt")

package dev.deftu.kolor

import java.awt.Color as AwtColor

public fun Color.toAwt(): AwtColor {
    return AwtColor(red, green, blue, alpha)
}

public fun AwtColor.toKolor(): Color {
    return Kolor.rgba(
        red = red,
        green = green,
        blue = blue,
        alpha = alpha
    )
}
