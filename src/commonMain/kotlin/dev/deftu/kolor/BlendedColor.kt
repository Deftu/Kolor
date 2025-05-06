package dev.deftu.kolor

public class BlendedColor(
    public val from: Color,
    public val to: Color,
    public val ratioProvider: () -> Float,
) : Color(from.alpha, from.hue, from.saturation, from.brightness) {

    private var _ratio: Float? = null

    public var ratio: Float
        get() = _ratio.also { _ratio = null } ?: ratioProvider()
        set(value) {
            _ratio = value
        }

    override val hue: Float
        get() = interpolate(from.hue, to.hue, ratio)

    override val saturation: Float
        get() = interpolate(from.saturation, to.saturation, ratio)

    override val brightness: Float
        get() = interpolate(from.brightness, to.brightness, ratio)

    private fun interpolate(from: Float, to: Float, ratio: Float): Float {
        return from + (to - from) * ratio
    }

}
