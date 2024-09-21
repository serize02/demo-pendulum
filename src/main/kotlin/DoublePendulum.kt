package org.simulation

import kotlin.math.cos
import kotlin.math.sin

data class DoublePendulum(
    var theta1: Double,
    var theta2: Double,
    var p1: Double,
    var p2: Double,
    val L1: Double,
    val L2: Double,
    val m1: Double,
    val m2: Double,
    val g: Double
) {
    private val halfPi = Math.PI / 2

    fun equations(): (DoubleArray) -> DoubleArray {
        return { y ->
            val theta1 = y[0]
            val theta2 = y[1]
            val p1 = y[2]
            val p2 = y[3]

            val delta = theta2 - theta1
            val denom1 = (m1 + m2) * L1 - m2 * L1 * cos(delta) * cos(delta)
            val denom2 = (L2 / L1) * denom1

            val dtheta1dt = (L2 * p1 - L1 * p2 * cos(delta)) / (L1 * L1 * denom1)
            val dtheta2dt = (2 * L1 * p2 - 2 * L2 * p1 * cos(delta)) / (L2 * L2 * denom2)

            val dp1dt = -(m1 + m2) * g * L1 * sin(theta1) - dtheta1dt * dtheta2dt * sin(delta)
            val dp2dt = -m2 * g * L2 * sin(theta2) + dtheta1dt * dtheta2dt * sin(delta)

            doubleArrayOf(dtheta1dt, dtheta2dt, dp1dt, dp2dt)
        }
    }
}