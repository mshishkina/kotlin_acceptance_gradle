plugins {
    kotlin("jvm") apply false
    id("org.jetbrains.dokka")
}

group = "org.jetbrains.kotlin"
version = "1.0-SNAPSHOT"

val kotlin_version: String by project
val junit_version: String by project

allprojects {
    repositories {
        mavenCentral()
        jcenter()
        maven("https://dl.bintray.com/kotlin/kotlin-dev")
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
        maven("%teamcity_artifacts_link_key%")
    }
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
    }

    val implementation by configurations
    val testImplementation by configurations

    dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")
        testImplementation("junit:junit:$junit_version")
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    }
}
