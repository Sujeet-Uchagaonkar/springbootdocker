FROM openjdk:8-jdk-alpine
EXPOSE 8081
RUN mkdir -p /app/
ADD build/libs/dockerdemo-0.0.1-SNAPSHOT.jar /app/dockerdemo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/dockerdemo-0.0.1-SNAPSHOT.jar"]