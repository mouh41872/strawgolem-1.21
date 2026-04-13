pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.minecraftforge.net/")
        maven("https://maven.neoforged.net/releases/")
    }
}

plugins {
    id("dev.kikugie.stonecutter") version "0.7.7"
}

stonecutter {
    kotlinController = true
    centralScript = "build.gradle.kts"

    shared {
        // Here is the trick: Display name 1.21.11, but files from 1.21.1
        version("1.21.11-forge", "1.21.1")
    }
    create(rootProject)
}

rootProject.name = "Straw Golem"
