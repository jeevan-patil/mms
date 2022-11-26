FROM openjdk:17-jdk-slim
ADD build/libs/mms-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]