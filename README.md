spring-boot-security-example  [![Build Status](https://travis-ci.org/haycco/spring-boot-security-example.svg?branch=master)](https://travis-ci.org/haycco/spring-boot-security-example)
============================

Copied from other place. I have changed gradle to pom and updated spring-boot version for 2.0.0.RELEASE

This project demonstrates usage of Spring-Boot with Spring-Security using Java configuration with Integration Tests

Any more you can read original author Technical Blog(http://www.future-processing.pl/blog/exploring-spring-boot-and-spring-security-custom-token-based-authentication-of-rest-services-with-spring-security-and-pinch-of-spring-java-configuration-and-spring-integration-testing/)

Requirements
============================
* [Java Platform (JDK) 8+](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven 3.2+](http://maven.apache.org/)

Quick start
============================
1. `mvn clean install`
2. `mvn spring-boot:run`
3. Point your browser to [https://localhost:8443/health](https://localhost:8443/health)