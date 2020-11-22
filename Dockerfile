FROM openjdk:14.0.2-jdk
COPY ./target/*.jar /app.jar
EXPOSE 8087
ENTRYPOINT ["java","-jar","/app.jar"]