plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
}

group = "io.github.opletter"
version = "1.0-SNAPSHOT"

kotlin {
    js(IR) {
        browser()
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime) // commenting this out and uncommenting in jsMain fixes the issue
            }
        }
        val jsMain by getting {
            dependencies {
//                implementation(compose.runtime)
                implementation(compose.html.core)
            }
        }
    }
}