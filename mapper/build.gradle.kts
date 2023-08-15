plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    // MapStruct
    implementation("org.mapstruct:mapstruct:1.5.5.Final")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")

    implementation(project(":domain"))
}
