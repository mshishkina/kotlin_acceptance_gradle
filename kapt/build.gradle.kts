plugins {
    id("org.jetbrains.kotlin.kapt")
}

group = "org.jetbrains.kotlin"
version = "1.0-SNAPSHOT"

val querydsl_version: String by project
val h2_version: String by project
val hibernate_version: String by project

dependencies {
    compile("com.mysema.querydsl:querydsl-jpa:$querydsl_version")
    kapt("com.mysema.querydsl:querydsl-apt:$querydsl_version:jpa")
    compile("org.hibernate:hibernate-entitymanager:$hibernate_version")
    compile("com.h2database:h2:$h2_version")
}