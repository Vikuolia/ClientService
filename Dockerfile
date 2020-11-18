FROM openjdk:11-jre
WORKDIR D: /3 курс/ТРСПО/lab3/client/out/artifacts/client_jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/app.jar"]