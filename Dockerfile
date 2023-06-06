# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim-buster AS build

# Set the working directory to /app
WORKDIR /app

# Copy the Gradle build files
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# Run the Gradle wrapper to download and cache the dependencies
RUN ./gradlew build || return 0

# Copy the application code
COPY src ./src

# Build the application
RUN ./gradlew build

# Create a new image based on the slim OpenJDK runtime image
FROM openjdk:17-jdk-slim-buster

# Set the working directory to /app
WORKDIR /app

# Copy the built application from the previous stage to this stage
COPY --from=build /app/build/libs/*.jar ./app.jar

# Expose the port that the application listens on
EXPOSE 8080

# Set the default command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]