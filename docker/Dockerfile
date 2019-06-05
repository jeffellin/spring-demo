FROM openjdk:8-jdk-alpine
COPY web-demo.jar .
LABEL snapshot=true
EXPOSE 8080
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "web-demo.jar"]
