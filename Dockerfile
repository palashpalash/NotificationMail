# Use Eclipse Temurin JDK 17 base image
FROM eclipse-temurin:17-jdk

# Set working directory inside container
WORKDIR /app

# Copy WAR file into image (from target folder)
COPY target/NotificationMail-0.0.1-SNAPSHOT.war /app/NotificationMail-0.0.1-SNAPSHOT.war

# Expose application port (change if needed)
EXPOSE 8081

# Run the Spring Boot WAR
CMD ["java", "-jar", "/app/NotificationMail-0.0.1-SNAPSHOT.war"]
