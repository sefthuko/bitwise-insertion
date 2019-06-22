import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.31"
}

group = "com.sefthuko"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("org.assertj:assertj-core:3.12.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.4.2")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}