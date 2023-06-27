vim ~/.bashrc 
mvn clean package
vim ~/.bashrc 
source ~/.bashrc 
java -version

windup-cli --input target/crud-1.0.0.jar --output /home/parraes/quarkus/mta-quarkus --target openjdk17 quarkus resteasy cloud-readiness


## RESTful CRUD using Spring Boot, H2 database and Swagger UI

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
