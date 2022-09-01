FROM openjdk:11.0.7

 VOLUME /tmp
  EXPOSE 8069
  ADD ./target/ms-customer-0.0.1-SNAPSHOT.jar ms-customer.jar
  ENTRYPOINT ["java","-jar","/ms-customer.jar"]

# ARG JAR_FILE=target/eureka-server-*.jar
#
# ENV JAVA_OPTS="-Xms64m -Xmx256m"
#
# COPY ${JAR_FILE} eureka-server.jar
#
# ENTRYPOINT java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -server -jar eureka-server.jar
