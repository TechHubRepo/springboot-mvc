FROM ubuntu:22.04
LABEL maintainer TechHub
RUN apt-get -y update
RUN apt-get -y install openjdk-17-jdk
ADD /target/mvc-demo-latest.war mvc-demo-latest.war
EXPOSE 8082
ENTRYPOINT ["java","-jar","mvc-demo-latest.war"]
