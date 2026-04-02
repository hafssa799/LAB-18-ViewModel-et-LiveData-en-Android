plugins {
    alias(libs.plugins.android.application)
}

android {
<<<<<<< HEAD
    namespace = "projet.fst.ma.viewmodellivedatademoenrichi"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "projet.fst.ma.viewmodellivedatademoenrichi"
=======
    namespace = "com.example.viewmodellivedatademoenrichi"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.viewmodellivedatademoenrichi"
>>>>>>> 4b9c34571268ab8ed478268d9df9a07b4de83769
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
<<<<<<< HEAD
    testImplementation(libs.junit)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7")

    // Pour utiliser ViewModelProvider en Java
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.7")
=======
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
    testImplementation(libs.junit)
>>>>>>> 4b9c34571268ab8ed478268d9df9a07b4de83769
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}