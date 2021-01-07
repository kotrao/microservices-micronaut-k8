FROM openjdk:14-alpine
RUN apk --no-cache add curl
WORKDIR /home/app
COPY build/libs/*-all.jar /home/app/application.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/home/app/application.jar"]
