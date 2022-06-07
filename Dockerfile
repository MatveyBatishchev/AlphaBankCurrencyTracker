FROM openjdk:15.0.2
ARG JAR_FILE=build/libs/AlphaBankCurrencyTracker-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]