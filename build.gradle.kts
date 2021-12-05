// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.20")
        classpath("com.google.gms:google-services:4.3.10")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
allprojects {
    repositories {

        // Check that you have the following line (if not, add it):
        google()  // Google's Maven repository
    }

}
tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}
