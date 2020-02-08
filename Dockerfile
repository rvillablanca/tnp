FROM openjdk:8-jdk-alpine

COPY target/tnp-1.0.jar tnp-1.0.jar

ENTRYPOINT ["java","-jar","/tnp-1.0.jar"]