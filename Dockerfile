# --- Stage 1: Build the application ---
FROM gradle:8.5.0-jdk17 AS build
WORKDIR /app

# Copy only relevant Gradle files first to cache dependencies
COPY build.gradle.kts gradle.properties /app/
COPY gradle /app/gradle

# Download dependencies
RUN gradle --no-daemon build || return 0

# Copy the rest of the source code
COPY . /app

# Build the application
RUN gradle clean bootJar --no-daemon

# --- Stage 2: Create a minimal image for running the app ---
FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
WORKDIR /app

# Copy the jar from the previous build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose port (default Spring Boot port)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]
