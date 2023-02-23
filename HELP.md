# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.2/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.2/gradle-plugin/reference/html/#build-image)
* [GraalVM Native Image Support](https://docs.spring.io/spring-boot/docs/3.0.2/reference/html/native-image.html#native-image)
* [Testcontainers MongoDB Module Reference Guide](https://www.testcontainers.org/modules/databases/mongodb/)
* [Testcontainers R2DBC support Reference Guide](https://www.testcontainers.org/modules/databases/r2dbc/)
* [Testcontainers Postgres Module Reference Guide](https://www.testcontainers.org/modules/databases/postgres/)
* [Coroutines section of the Spring Framework Documentation](https://docs.spring.io/spring/docs/6.0.4/spring-framework-reference/languages.html#coroutines)
* [Java Mail Sender](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#io.email)
* [Quartz Scheduler](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#io.quartz)
* [Contract Stub Runner](https://cloud.spring.io/spring-cloud-contract/reference/htmlsingle/#features-stub-runner)
* [Spring Data R2DBC](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#data.sql.r2dbc)
* [Contract Verifier](https://cloud.spring.io/spring-cloud-contract/reference/htmlsingle/)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#web.reactive)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#actuator)
* [Resilience4J](https://docs.spring.io/spring-cloud-circuitbreaker/docs/current/reference/html/#configuring-resilience4j-circuit-breakers)
* [RSocket](https://rsocket.io/)
* [Rest Repositories](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#howto.data-access.exposing-spring-data-repositories-as-rest)
* [Spring Data Reactive Redis](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#data.nosql.redis)
* [Liquibase Migration](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#howto.data-initialization.migration-tool.liquibase)
* [Spring cache abstraction](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#io.caching)
* [Prometheus](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#actuator.metrics.export.prometheus)
* [Spring Data Reactive MongoDB](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#data.nosql.mongodb)
* [Validation](https://docs.spring.io/spring-boot/docs/3.0.2/reference/htmlsingle/#io.validation)
* [Testcontainers](https://www.testcontainers.org/)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing data with R2DBC](https://spring.io/guides/gs/accessing-data-r2dbc/)
* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)
* [Accessing Neo4j Data with REST](https://spring.io/guides/gs/accessing-neo4j-data-rest/)
* [Accessing MongoDB Data with REST](https://spring.io/guides/gs/accessing-mongodb-data-rest/)
* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)
* [Caching Data with Spring](https://spring.io/guides/gs/caching/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Configure AOT settings in Build Plugin](https://docs.spring.io/spring-boot/docs/3.0.2/gradle-plugin/reference/htmlsingle/#aot)
* [R2DBC Homepage](https://r2dbc.io)

## GraalVM Native Support

This project has been configured to let you generate either a lightweight container or a native executable.
It is also possible to run your tests in a native image.

### Lightweight Container with Cloud Native Buildpacks

If you're already familiar with Spring Boot container images support, this is the easiest way to get started.
Docker should be installed and configured on your machine prior to creating the image.

To create the image, run the following goal:

```
$ ./gradlew bootBuildImage
```

Then, you can run the app like any other container:

```
$ docker run --rm bratok:0.0.1-SNAPSHOT
```

### Executable with Native Build Tools

Use this option if you want to explore more options such as running your tests in a native image.
The GraalVM `native-image` compiler should be installed and configured on your machine.

NOTE: GraalVM 22.3+ is required.

To create the executable, run the following goal:

```
$ ./gradlew nativeCompile
```

Then, you can run the app as follows:

```
$ build/native/nativeCompile/bratok
```

You can also run your existing tests suite in a native image.
This is an efficient way to validate the compatibility of your application.

To run your existing tests in a native image, run the following goal:

```
$ ./gradlew nativeTest
```

