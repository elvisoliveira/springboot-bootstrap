FROM maven:3.6.1-jdk-8
MAINTAINER Elvis Oliveira <elvis.olv@gmail.com>

WORKDIR /${DIRECTORY}
COPY . .
RUN mvn package spring-boot:repackage -DskipTests

ENTRYPOINT java -jar ./target/elvisoliveira-0.0.1-SNAPSHOT.jar