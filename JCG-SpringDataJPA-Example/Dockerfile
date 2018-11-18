FROM picoded/ubuntu-openjdk-8-jdk

MAINTAINER rashmit.rathod@yahoo.com

ADD target/person-service-1.0.jar /opt/

RUN chmod 777 /opt/person-service-1.0.jar && mkdir -p safetynet-config

CMD ["java","-jar","/opt/person-service-1.0.jar"]