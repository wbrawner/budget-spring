import java.net.URI

plugins {
    java
    kotlin("jvm")
    id("org.springframework.boot")
}

apply(plugin = "io.spring.dependency-management")

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        url = URI("http://repo.maven.apache.org/maven2")
    }
}

val kotlinVersion: String by rootProject.extra

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.session:spring-session-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly("mysql:mysql-connector-java:8.0.15")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test:5.1.5.RELEASE")
}

description = "twigs-server"

val twigsMain = "com.wbrawner.budgetserver.TwigsServerApplication"

tasks.bootJar {
    mainClassName = twigsMain
}

tasks.bootRun {
    main = twigsMain
}
