package org.simulation

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration

fun main() {
    val config = Lwjgl3ApplicationConfiguration().apply {
        setTitle("Double Pendulum Simulation")
        setWindowedMode(1000, 1000)
    }
    Lwjgl3Application(DoublePendulumSimulationApp(), config)
}