# Migration SpringBoot to Quarkus Cloud Native
This source demonstrates the differences between a Spring Boot application and the same application migrated to Quarkus, running in a native cloud environment. The 'master' branch contains the original application, which was forked from the "https://github.com/CGumera/spring-crud". In the 'quarkus' branch, the code was modified to run using Quarkus in a cloud-native environment. To facilitate comparison, a Containerfile was added to the 'master' branch to simulate conditions similar to the 'Quarkus' branch. However, the original application itself remains unmodified.


# Requirements
* OpenJDK 1.8 for Spring-Boot branch (master) (https://developers.redhat.com/content-gateway/file/openjdk/July_2023/java-1.8.0-openjdk-portable-1.8.0.382.b05-2.portable.jdk.el.x86_64.tar.xz)
* OpenJDK 17 for Quarkus branch (quarkus) (https://developers.redhat.com/content-gateway/file/openjdk/17.0.8/java-17-openjdk-17.0.8.0.7-1.portable.jdk.el.x86_64.tar.xz)
* Podman (https://podman.io/docs/installation)

Other versions of Red Hat OpenJDK Build are available at https://developers.redhat.com/products/openjdk/download#assembly-field-downloads-page-content-82031. Please note that all versions of this tutorial have been implemented and tested on Fedora Linux. Before downloading and installing the requirements, kindly verify your operating system version for compatibility.

## To compile and run a Spring Boot application, you'll need to follow these steps:

Set up your development environment:

Install Java Development Kit (JDK 1.8) on your system.
Install a code editor or an Integrated Development Environment (IDE) such as Eclipse, IntelliJ IDEA, or Visual Studio Code.
Create a new Spring Boot project or clone an existing one from version control.

Build the project:

Open a terminal or command prompt and navigate to the root folder of your Spring Boot project.
Use a build tool like Maven or Gradle to compile the application and package it into an executable JAR file.
For Maven, use the following command:

## Two ways to run the application:
1. Import the project to an IDE then run the CrudApplication class
2. Run the jar file with filename "crud-1.0.0.jar" inside the crud/target folder

## Using the Application:
1. Use Swagger UI to test the endpoints. URL = http://localhost:8888/swagger-ui.html#/
2. Use H2 Console to access the database. URL = http://localhost:8888/h2-console

## H2 Console Credentials:
1. JDBC URL = jdbc:h2:mem:shop
2. User Name = sa
3. Password = password


