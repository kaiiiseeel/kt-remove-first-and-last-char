plugins {
    id ("java")
    id ("org.jetbrains.kotlin.jvm")
    application
    id("io.gitlab.arturbosch.detekt") version "1.23.3"
}

group = "mate.academy"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

detekt {
    buildUponDefaultConfig = true // preconfigure defaults
    allRules = false // activate all available (even unstable) rules.
    baseline = file("$projectDir/config/baseline.xml") // a way of suppressing issues before introducing detekt
}