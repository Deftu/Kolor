pluginManagement {
    repositories {
        // Snapshots
        maven("https://maven.deftu.dev/snapshots")
        maven("https://s01.oss.sonatype.org/content/groups/public/")

        // Repositories
        maven("https://maven.deftu.dev/releases")
        maven("https://maven.fabricmc.net")
        maven("https://maven.architectury.dev/")
        maven("https://maven.minecraftforge.net")
        maven("https://repo.essential.gg/repository/maven-public")
        maven("https://jitpack.io/")

        // Default repositories
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }

    plugins {
        id("dev.deftu.gradle.multiversion-root") version("2.34.0")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("0.8.+")
}

rootProject.name = extra["project.name"]?.toString() ?: throw IllegalStateException("project.name is not defined")
