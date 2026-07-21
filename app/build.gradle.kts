plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "dev.wvb.testapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.wvb.testapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    // Left completely empty because we are using native Android tools!
}
