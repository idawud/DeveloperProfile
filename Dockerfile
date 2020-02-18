FROM adoptopenjdk:11-jre-hotspot

RUN gradlew bootJar
COPY build/libs/DeveloperProfile-0.0.1-SNAPSHOT.jar   app.jar
RUN chmod 777 app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]