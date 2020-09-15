import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
}

group = "org.jetbrains.kotlin"
version = "1.0-SNAPSHOT"

application {
    mainClassName = "demo.HelloWorldKt"
    defaultTasks = mutableListOf("run")
}

dependencies {
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        languageVersion = "1.3"
        apiVersion = "1.3"
    }
}