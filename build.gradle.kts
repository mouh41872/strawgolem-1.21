plugins {
    kotlin("jvm") version "1.9.24"
    id("dev.architectury.loom") version "1.7-SNAPSHOT"
    id("dev.kikugie.stonecutter") version "0.7.7"
}

stonecutter {
    centralScript = true
}

// Basic configurations
group = "com.t2pellet.strawgolem"
version = "2.3.0-beta"

repositories {
    mavenCentral()
    maven("https://maven.minecraftforge.net/")
    maven("https://maven.architectury.dev/")
    maven("https://maven.shedaniel.me/")
    maven("https://api.modrinth.com/maven")
    maven("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
}

dependencies {
    // We use 1.21.1 as the base to support your 1.21.11
    minecraft("com.mojang:minecraft:1.21.1")
    mappings(loom.officialMojangMappings())
    
    // Forge dependency
    "forge"("net.minecraftforge:forge:1.21.1-51.0.8")

    // Core Mod Dependencies (Geckolib is required for Straw Golem)
    modImplementation("software.bernie.geckolib:geckolib-forge-1.21.1:4.5.1")
}

loom {
    silentMojangMappingsLicense()
    forge {
        mixinConfigs("mixins.strawgolem.json")
    }
}

tasks.processResources {
    val map = mapOf(
        "id" to "strawgolem",
        "name" to "Straw Golem",
        "version" to "2.3.0-beta",
        "description" to "Adds a helpful lil' Straw Golem. He's a farmer!",
        "authors" to "CommodoreThrawn",
        "issue_tracker" to "https://github.com/godemperoroftheworld/strawgolem/issues",
        "license" to "AGPLv3",
        "forgelike_loader_ver" to "51"
    )

    inputs.properties(map)

    filesMatching("META-INF/mods.toml") {
        expand(map + mapOf("depends" to ""))
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}
