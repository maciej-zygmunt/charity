FROM adoptopenjdk:11-jre-openj9
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} charity.jar
ENTRYPOINT ["java","-jar","charity.jar"]
