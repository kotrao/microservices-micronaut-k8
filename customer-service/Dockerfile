FROM openjdk:14-alpine
RUN apk --no-cache add curl
WORKDIR /home/app
COPY build/libs/*-all.jar /home/app/application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djdk.tls.client.protocols=TLSv1.2", "-jar", "/home/app/application.jar"]
