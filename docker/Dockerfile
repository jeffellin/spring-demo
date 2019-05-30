FROM openjdk:8-jdk-alpine
COPY web-demo.jar .

ENV SPRING_DATASOURCE_USERNAME=""
ENV SPRING_DATASOURCE_PASSWORD=""
ENV SPRING_DATASOURCE_URL=jdbc:mysql://192.168.1.151:3306/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
EXPOSE 8080
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "web-demo.jar"]
