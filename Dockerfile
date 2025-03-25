FROM maven:3.9-eclipse-temurin-21 as build

WORKDIR /app

# Copy pom.xml and source code
COPY pom.xml .
COPY src src

# Build the application
RUN mvn package -DskipTests

# Second stage: runtime
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port
EXPOSE 8080
EXPOSE 5432

# Set entry point
ENTRYPOINT ["java", "-jar", "app.jar"]
