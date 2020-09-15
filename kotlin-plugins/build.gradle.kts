plugins {
    id("org.jetbrains.kotlin.plugin.allopen")
    id("org.jetbrains.kotlin.plugin.noarg")
}

group = "org.jetbrains.kotlin"
version = "1.0-SNAPSHOT"

allOpen {
    annotation("plugin.OpenClass")
}

noArg {
    annotation("plugin.NoArgClass")
}