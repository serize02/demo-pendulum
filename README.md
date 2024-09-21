# Double Pendulum Simulation

![](https://github.com/serize02/demo-pendulum/blob/main/src/main/resources/Double%20Pendulum%20Simulation%202024-09-21%2001-30-28.gif)

This project simulates a double pendulum using `LibGDX`, a cross-platform game development framework in Java, and Kotlin. The simulation includes the implementation of the Runge-Kutta method for solving differential equations.

## Project Structure

- **DoublePendulumSimulationApp**: The main application class extending `ApplicationAdapter` from `LibGDX`.
- **DoublePendulum**: Represents the double pendulum system including properties like angles, momenta, lengths, masses, and acceleration due to gravity.
- **rungeKutta4**: Implements the 4th order Runge-Kutta method to solve differential equations representing the double pendulum motion.
  
## Usage

### Running the Simulation

1. Clone the repository.
2. Ensure you have `JDK` and `Gradle` installed.
3. Open a terminal, navigate to the project root and execute:

   ```sh
    ./gradlew run
    ```
