include(
        "kotlin-pure",
        "kotlin-plugins",
        "kotlin-java",
        "kapt",
        "dokka"
)

pluginManagement {
    resolutionStrategy {
        repositories {
            mavenCentral()
            jcenter()
            maven("https://dl.bintray.com/kotlin/kotlin-dev")
            maven("https://dl.bintray.com/kotlin/kotlin-eap")
            maven("%teamcity_artifacts_link_key%")
        }
        eachPlugin {

            if (requested.id.id.startsWith("org.jetbrains.kotlin")) {
                useVersion(gradle.rootProject.extra["kotlin_version"] as String)
            }
            if (requested.id.id.startsWith("org.jetbrains.dokka")) {
                useModule("org.jetbrains.dokka:dokka-gradle-plugin:${gradle.rootProject.extra["dokka_version"] as String}")
            }
        }
    }
}