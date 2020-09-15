import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    id("org.jetbrains.dokka")
}

group = "org.jetbrains.kotlin"
version = "1.0-SNAPSHOT"

application {
    mainClassName = "demo.HelloWorld"
}

sourceSets {
    create("deploy") {
        compileClasspath = getByName("main").compileClasspath
    }
}

dependencies {
    testCompile(sourceSets.getByName("deploy").output)
}

tasks.withType(KotlinCompile::class) {
    kotlinOptions {
        jvmTarget = "1.8"
        languageVersion = "1.3"
        apiVersion = "1.3"
    }
}