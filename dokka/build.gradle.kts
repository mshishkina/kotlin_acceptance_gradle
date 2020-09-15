//import org.jetbrains.dokka.gradle.DokkaTask
//import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.dokka")
}

group = "org.jetbrains.kotlin"
version = "1.0-SNAPSHOT"

//tasks {
//    val dokka by getting(DokkaTask::class) {
//        cacheRoot = "default"
//        configuration {
//            includes = listOf("README.md")
//            sourceLink {
//                path = "$projectDir"
//                url = "https://github.com/JetBrains/kotlin-examples/tree/master/gradle/dokka-gradle-example"
//                lineSuffix = "#L"
//            }
//        }
//    }
//
//    create("dokkaJavadoc", DokkaTask::class) {
//        outputFormat = "javadoc"
//        outputDirectory = "$buildDir/dokkaJavadoc"
//    }
//
//    withType(KotlinCompile::class) {
//        kotlinOptions {
//            jvmTarget = "1.6"
//            languageVersion = "1.3"
//            apiVersion = "1.3"
//        }
//    }
//}



