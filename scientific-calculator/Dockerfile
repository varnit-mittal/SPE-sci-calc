# Use a Maven image to build the Spring Boot app
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and source
COPY pom.xml .
COPY src ./src

RUN mvn clean test
# Package the app (skip tests for faster build)
RUN mvn clean package -DskipTests

# Use lightweight JDK image for runtime
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the built jar
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8081

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
