FROM openjdk:17
EXPOSE 8081
ADD target/spring-boot-rest-1-github-actions.jar spring-boot-rest-1-github-actions.jar
ENTRYPOINT ["java","-jar","/spring-boot-rest-1-github-actions.jar"]