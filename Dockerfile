# --- Stage 1: Build the application ---
FROM gradle:8.5.0-jdk17 AS build
WORKDIR /app

# Copy the entire project (since we can't rely on split caching)
COPY . .

# Build the application (create fat jar)
RUN gradle clean bootJar --no-daemon

# --- Stage 2: Run the application ---
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy jar from previous stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose port (adjust if needed)
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
