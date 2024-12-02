import org.springframework.boot.gradle.tasks.bundling.BootBuildImage
plugins {
	java
	id("org.springframework.boot") version "3.3.5"
	id("org.springframework.boot.aot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	//testRuntimeOnly("com.h2database:h2")
	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.testcontainers:mysql")
	testImplementation("org.testcontainers:junit-jupiter")
}
tasks.named<BootBuildImage>("bootBuildImage") {
	// Enable CDS and Spring AOT
	environment.put("BP_JVM_CDS_ENABLED", "true")
	//environment.put("BP_SPRING_AOT_ENABLED", "true")
	//environment.put("BP_LOG_LEVEL", "DEBUG")

}


tasks.withType<Test> {
	useJUnitPlatform()
}
