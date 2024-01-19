FROM openjdk:17-jdk

#COPY gradlew .
#COPY gradle gradle
#COPY build.gradle .
#COPY settings.gradle .
#COPY src src
#RUN chmod +x ./gradlew
#RUN ["./gradlew", "clean", "bootJar"]

ARG JAR_FILE_PATH=build/libs/*.jar

COPY ${JAR_FILE_PATH} app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]