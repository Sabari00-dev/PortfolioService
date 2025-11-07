# ==============================
# Stage 1: Build the project
# ==============================
FROM eclipse-temurin:17-jdk AS build

# Set working directory
WORKDIR /app

# Copy all source code into container
COPY . .

# Build the project (creates /app/target/*.jar)
RUN ./mvnw clean package -DskipTests || mvn clean package -DskipTests


# ==============================
# Stage 2: Run the app
# ==============================
FROM eclipse-temurin:17-jdk

# Set working directory inside container
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port Render will use
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
