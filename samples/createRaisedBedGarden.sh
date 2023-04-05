#!/bin/bash

mvn archetype:generate -DarchetypeGroupId=org.example \
 -DarchetypeArtifactId=springboot-archetype \
 -DarchetypeVersion=1.0-SNAPSHOT \
 -DgroupId=org.example.garden \
 -DartifactId=RaisedBedGarden \
 -Dversion=1.0-SNAPSHOT \
 -DmodelClass=Plant \
 -Dname=RaisedBedGarden \
 -Ddescription='Raised Bed Garden ' \
 -DrestEndpoint=/api/v1/garden \
 -DserviceName=Garden


