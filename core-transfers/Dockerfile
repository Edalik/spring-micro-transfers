FROM amazoncorretto:17.0.14-alpine
EXPOSE 8080
COPY ./build/libs/*.jar mt-core-transfers.jar
ENTRYPOINT ["java", "-jar", "/mt-core-transfers.jar"]