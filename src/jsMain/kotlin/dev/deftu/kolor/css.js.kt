package dev.deftu.kolor

/**
 * Returns a CSS-compatible string representation of this color.
 *
 * If this color matches a CSS named color, returns the name.
 * Otherwise returns "rgb(...)" or "rgba(...)" string.
 */
public fun Color.toCss(): String {
    val name: String? = NamedColors.getColorName(this)
    return name ?: if (alpha == 255) {
        "rgb($red, $green, $blue)"
    } else {
        val alphaFloat = alpha / 255f
        "rgba($red, $green, $blue, $alphaFloat)"
    }
}
