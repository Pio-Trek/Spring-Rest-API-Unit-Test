# Integrity and mock test with JUnit and Mockito for Spring RESTful

![Spring Boot RESTful logo](https://github.com/Pio-Trek/Spring-Rest-API-Test/blob/master/logo.png)

This is a Spring Boot Maven demo app showing how to perform integrity and mock test for Sprig Boot RESTful service using JUnit and Mockito Framework.

## Pre-requisites

- Java SE Development Kit 8
- Maven 3.0+
- H2 In-Memory Database _(can work with any other relational database)_

## Getting Started

Import the Maven project straight to your Java IDE:
- Intellij IDEA
- Spring Tool Suite (STS)
- Eclipse

_(OPTIONAL) To work with other RDBMS you need to configure the project 'application.properties' file match to your database URL, username, password and add a required Maven dependency._

## Technology Stack
The project uses the following technologies:
- **REST**: [Spring Boot](https://projects.spring.io/spring-boot/)
- **Marshalling**: [Jackson](https://github.com/FasterXML/jackson-databind) (for JSON fromat)
- **Persistence**: [Spring Data JPA](https://projects.spring.io/spring-data-jpa/) and [Hibernate](http://www.hibernate.org/)
- **Databse**: [H2](http://www.h2database.com)
- **Testing**: [junit](https://junit.org/junit4/), [hamcrest](http://hamcrest.org/JavaHamcrest/), [mockito](http://mockito.org/)

# License
Copyright 2018 Piotr Przechodzki

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
