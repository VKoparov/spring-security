plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    // Data MongoDB
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:3.1.2")

    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":mapper"))
}
