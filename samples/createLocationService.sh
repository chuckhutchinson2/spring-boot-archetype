#!/bin/bash

mvn archetype:generate -DarchetypeGroupId=org.example \
 -DarchetypeArtifactId=springboot-archetype \
 -DarchetypeVersion=1.0-SNAPSHOT \
 -DgroupId=org.example.location \
 -DartifactId=LocationServices \
 -Dversion=1.0-SNAPSHOT \
 -DmodelClass=Location \
 -Dname=LocationServices \
 -Ddescription='Location Location that provides US city, state, zip, lat, long location data' \
 -DrestEndpoint=/api/v1/location \
 -DserviceName=Location

