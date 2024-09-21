package org.simulation

fun rungeKutta4(y: DoubleArray, dydt: (DoubleArray) -> DoubleArray, dt: Double): DoubleArray {
    val k1 = dydt(y)
    val k2 = dydt(y.zip(k1) { y_i, k1_i -> y_i + 0.5 * dt * k1_i }.toDoubleArray())
    val k3 = dydt(y.zip(k2) { y_i, k2_i -> y_i + 0.5 * dt * k2_i }.toDoubleArray())
    val k4 = dydt(y.zip(k3) { y_i, k3_i -> y_i + dt * k3_i }.toDoubleArray())
    return y.zip(k1.indices) { y_i, i -> y_i + dt / 6 * (k1[i] + 2 * k2[i] + 2 * k3[i] + k4[i]) }.toDoubleArray()
}