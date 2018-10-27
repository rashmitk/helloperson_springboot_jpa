FROM webcenter/openjdk-jre

MAINTAINER rashmit.rathod@yahoo.com

ADD target/person-service-1.0.jar /opt/

RUN chmod 777 /opt/person-service-1.0.jar

EXPOSE 8091

CMD ["java","-jar","/opt/person-service-1.0.jar"]