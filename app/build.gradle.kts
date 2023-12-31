plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.jantonioc.mymovies"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jantonioc.mymovies"
        minSdk = 23
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    //Retrofit y GSON
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //Courrutines
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")

    //Activity y Fragment
    implementation("androidx.activity:activity-ktx:1.6.2")
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    //Ubicacion
    implementation("com.google.android.gms:play-services-location:21.0.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")


}