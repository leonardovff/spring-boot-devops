#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY . /home/app/
RUN mvn -f /home/app/pom.xml -Dmaven.test.skip -DskipTests clean package
#
# Package stage
#
FROM openjdk:11-jre-slim
RUN apt-get update && apt-get install netcat-openbsd -y
COPY --from=build /home/app/target/spring-boot-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
COPY ./docker-config/app/docker-startup.sh ./docker-startup.sh
EXPOSE 8080
ENTRYPOINT [ "sh" ]
CMD ["docker-startup.sh"]