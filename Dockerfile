FROM openjdk:latest

ADD target/jenkins-pipeline.jar jenkins-pipeline.jar

EXPOSE 8085

ENTRYPOINT ["java","-jar","jenkins-pipeline.jar"]