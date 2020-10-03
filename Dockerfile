FROM openjdk:latest

WORKDIR /app

COPY ./target/library-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "library-0.0.1-SNAPSHOT.jar"]