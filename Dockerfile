FROM openjdk:12-jdk-alpine
ADD target/kredyt.jar kredyt.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "kredyt.ja"]
