package dev.deftu.kolor

public class ColorTransform(base: Color) {

    private var current: Color = base

    public fun lighten(amount: Float): ColorTransform {
        current = current.lighten(amount)
        return this
    }

    public fun darken(amount: Float): ColorTransform {
        current = current.darken(amount)
        return this
    }

    public fun rotateHue(degrees: Float): ColorTransform {
        current = current.rotateHue(degrees)
        return this
    }

    public fun invert(): ColorTransform {
        current = current.invert()
        return this
    }

    public fun withAlpha(alpha: Int): ColorTransform {
        current = current.withAlpha(alpha)
        return this
    }

    public fun build(): StaticColor = current as? StaticColor ?: StaticColor(current.red, current.green, current.blue, current.alpha)

}
