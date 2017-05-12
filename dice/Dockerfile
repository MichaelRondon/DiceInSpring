FROM maven:latest
WORKDIR /app
ADD . /app
EXPOSE 8080
CMD mvn clean package
#FROM java:latest
CMD java -jar -Dserver.port=8080 target/dice-1.0.jar
#Se debe usar $(docker-machine ip default)
#https://github.com/boot2docker/boot2docker/issues/412 
