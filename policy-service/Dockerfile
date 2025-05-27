# Use an official JDK image as a base
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Add the JAR (adjust this if your JAR name is different)
COPY target/*.jar app.jar

# Expose the default port for Spring Boot (change if needed)
EXPOSE 8082

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
