FROM java
VOLUME /tmp
add ${project.artifactId}-${project.version}.jar application.jar
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]