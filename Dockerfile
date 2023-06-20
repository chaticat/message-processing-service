FROM openjdk:17-alpine
EXPOSE 8083
COPY ./build/libs/message-processing-service-0.0.1.jar /tmp/
WORKDIR /tmp
ENTRYPOINT ["java","-jar", "message-processing-service-0.0.1.jar"]