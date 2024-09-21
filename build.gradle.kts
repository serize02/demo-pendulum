plugins {
    kotlin("jvm") version "2.0.20"
}

group = "org.simulation"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("com.badlogicgames.gdx:gdx:1.9.14")
    implementation("com.badlogicgames.gdx:gdx-backend-lwjgl3:1.9.14")
    implementation("com.badlogicgames.gdx:gdx-platform:1.9.14:natives-desktop")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}