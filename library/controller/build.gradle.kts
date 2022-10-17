plugins {
    java
}

group = "vk.controller"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":model"))
    implementation("com.google.code.gson:gson:2.9.1")
    implementation("com.intellij:annotations:12.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}