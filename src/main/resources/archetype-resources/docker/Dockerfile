FROM chuckh/rhel7-jdk:latest

WORKDIR /opt/

ADD dist/${artifactId}-${version}.jar /opt/

CMD ["java", "-jar", "/opt/${artifactId}-${version}.jar" ]
