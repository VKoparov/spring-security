plugins {
    java
    id("org.springframework.boot") version "3.1.2" apply false
    id("io.spring.dependency-management") version "1.1.2"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenCentral()
    }

    dependencies {
        // Spring Context
        implementation("org.springframework:spring-context:6.0.11")
        implementation("org.springframework.boot:spring-boot-starter-actuator:3.1.2")

        // Spring Security
        implementation("org.springframework.boot:spring-boot-starter-security:3.1.2")
        implementation("org.springframework.boot:spring-boot-starter-validation:3.1.2")

        // Lombok
        implementation("org.projectlombok:lombok:1.18.28")
        annotationProcessor("org.projectlombok:lombok:1.18.28")

        // Testing
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("io.projectreactor:reactor-test")
        testImplementation("org.springframework.security:spring-security-test")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
