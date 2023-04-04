@Echo off
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 -jar ../target/${artifactId}-${version}.jar
