FROM openjdk:21-jdk
WORKDIR /app
COPY target/supermercado-api-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080