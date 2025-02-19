FROM amazoncorretto:17.0.14-alpine
EXPOSE 8080
COPY ./build/libs/*.jar limits.jar
ENTRYPOINT ["java", "-jar", "/limits.jar"]