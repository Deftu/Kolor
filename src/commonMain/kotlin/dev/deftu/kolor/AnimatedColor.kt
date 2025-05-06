package dev.deftu.kolor

public class AnimatedColor(
    private val timeProvider: () -> Long,
    private val animator: (Long) -> Color,
    alpha: Int = 255
) : Color(alpha) {

    public constructor(
        timeProvider: () -> Long,
        animator: (Long) -> Color,
        useResolvedAlpha: Boolean
    ) : this(timeProvider, animator, if (useResolvedAlpha) animator(timeProvider()).alpha else 255)

    public val backedColor: Color
        get() = animator(timeProvider())

    override val hue: Float
        get() = backedColor.hue

    override val saturation: Float
        get() = backedColor.saturation

    override val brightness: Float
        get() = backedColor.brightness

}
