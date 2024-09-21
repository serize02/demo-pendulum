package org.simulation

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import kotlin.math.cos
import kotlin.math.sin

class DoublePendulumSimulationApp : ApplicationAdapter() {
    lateinit var shapeRenderer: ShapeRenderer
    lateinit var pendulum: DoublePendulum

    override fun create() {
        shapeRenderer = ShapeRenderer()
        pendulum = DoublePendulum(
            theta1 = Math.PI, theta2 = Math.PI / 2,
            p1 = 0.0, p2 = 0.0,
            L1 = 200.0, L2 = 200.0,
            m1 = 1.0, m2 = 1.0,
            g = 9.8
        )
    }

    override fun render() {
        val dt = Gdx.graphics.deltaTime.toDouble() * 6
        val state = doubleArrayOf(pendulum.theta1, pendulum.theta2, pendulum.p1, pendulum.p2)
        val newState = rungeKutta4(state, pendulum.equations(), dt)
        pendulum.theta1 = newState[0]
        pendulum.theta2 = newState[1]
        pendulum.p1 = newState[2]
        pendulum.p2 = newState[3]

        val width = Gdx.graphics.width
        val height = Gdx.graphics.height

        val x1 = width / 2 + pendulum.L1 * sin(pendulum.theta1)
        val y1 = height / 2 - pendulum.L1 * cos(pendulum.theta1)
        val x2 = x1 + pendulum.L2 * sin(pendulum.theta2)
        val y2 = y1 - pendulum.L2 * cos(pendulum.theta2)

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line)
        shapeRenderer.color = com.badlogic.gdx.graphics.Color.WHITE
        shapeRenderer.line(width / 2f, height / 2f, x1.toFloat(), y1.toFloat())
        shapeRenderer.line(x1.toFloat(), y1.toFloat(), x2.toFloat(), y2.toFloat())
        shapeRenderer.end()

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
        shapeRenderer.circle(x1.toFloat(), y1.toFloat(), 10f)
        shapeRenderer.circle(x2.toFloat(), y2.toFloat(), 10f)
        shapeRenderer.end()
    }

    override fun dispose() {
        shapeRenderer.dispose()
    }
}