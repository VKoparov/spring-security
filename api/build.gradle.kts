apply(plugin = "org.springframework.boot")

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring Web
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation(project(":core"))
    implementation(project(":domain"))
    implementation(project(":security"))
    implementation(project(":mapper"))
}
