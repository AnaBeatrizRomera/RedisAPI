
FROM maven:3.8.4-openjdk-17 AS build
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package


FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
