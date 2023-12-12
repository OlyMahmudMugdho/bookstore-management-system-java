
FROM openjdk

WORKDIR /app

COPY ./apache-tomcat-9.0.82 /app/apache-tomcat-9.0.82


EXPOSE 8080

CMD ["/app/apache-tomcat-9.0.82/bin/catalina.sh", "run"]
