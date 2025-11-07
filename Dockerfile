# Step 1: Use an official JDK image
FROM eclipse-temurin:17-jdk

# Step 2: Set working directory inside container
WORKDIR /Portfolio

# Step 3: Copy your built jar file into the container
COPY target/*.jar Portfolio.jar

# Step 4: Expose the port Render will use
EXPOSE 8080

# Step 5: Command to run your app
ENTRYPOINT ["java", "-jar", "Portfolio.jar"]