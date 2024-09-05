# Etapa 1: Build
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN ./mvnw clean package

# Etapa 2: Run
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=Build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","app.jar"]
