import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.cloud.contract.verifier.config.TestMode

plugins {
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.graalvm.buildtools.native") version "0.9.18"
    id("org.springframework.cloud.contract") version "4.0.1"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
}

group = "com.infratech"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2022.0.1"
extra["testcontainersVersion"] = "1.17.6"

dependencies {
    // Метрики и мониторинг
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    // Кэширование
    implementation("org.springframework.boot:spring-boot-starter-cache")
    // Работа в реактивном стиле с mongodb
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    // Работа в реактивном стиле с postgresql
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    // Работа в реактивном стиле с redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
    // REST-репозитории Spring Data REST
    implementation("org.springframework.boot:spring-boot-starter-data-rest")
    // Отправка писем электронной почты
    implementation("org.springframework.boot:spring-boot-starter-mail")
    // Выполнение задач по расписанию
    implementation("org.springframework.boot:spring-boot-starter-quartz")
    // Протокол RSocket для front-end
    implementation("org.springframework.boot:spring-boot-starter-rsocket")
    // Валидатор DTO и Entity классов
    implementation("org.springframework.boot:spring-boot-starter-validation")
    // Реактивный стек Sping'а для построения API-сервисов
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    // Расширения jackson для использования с Kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    // Расширения Project Reactor для использования с Kotlin
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk9")
    // Миграции БД
    implementation("org.liquibase:liquibase-core")
    // JDBC (?)
    implementation("org.springframework:spring-jdbc")
    // Circuit Breaker для Spring
//    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-reactor-resilience4j")
    // Метрики и мониторинг
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")
    // Реактивный драйвер для postgresql
    runtimeOnly("org.postgresql:r2dbc-postgresql")
    // Библиотеки разработки telegram-бота
    // https://github.com/rubenlagus/TelegramBots самая популярная либа на Java
//    implementation("org.telegram:telegrambots:6.5.0")
    // https://github.com/InsanusMokrassar/TelegramBotAPI либа на Kotlin с поддержкой сопрограмм
    implementation("dev.inmo:tgbotapi:5.2.1")

    // Авто-тестирование
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("io.rest-assured:spring-web-test-client")
    testImplementation("org.springframework.cloud:spring-cloud-starter-contract-stub-runner")
    testImplementation("org.springframework.cloud:spring-cloud-starter-contract-verifier")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:mongodb")
    testImplementation("org.testcontainers:postgresql")
    testImplementation("org.testcontainers:r2dbc")
}

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.contractTest {
    useJUnitPlatform()
}

contracts {
    testMode.set(TestMode.WEBTESTCLIENT)
}

