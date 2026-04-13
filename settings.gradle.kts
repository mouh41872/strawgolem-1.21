pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.fabricmc.net/")
        maven("https://maven.architectury.dev")
        maven("https://maven.minecraftforge.net/")
        maven("https://maven.neoforged.net/releases/")
        maven("https://repo.spongepowered.org/maven")
    }
}

plugins {
    id("dev.kikugie.stonecutter") version "0.7.7"
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

stonecutter {
    kotlinController = true
    centralScript = "build.gradle.kts"

    shared {
        // We use 1.21.1 as the library base
        version("1.21.1", "1.21.1")
    }
    // This tells the system to use 1.21.1 as the active project
    create(rootProject, "1.21.1")
}

rootProject.name = "Straw Golem"
