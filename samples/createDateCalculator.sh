#!/bin/bash

mvn archetype:generate -DarchetypeGroupId=org.example \
 -DarchetypeArtifactId=springboot-archetype \
 -DarchetypeVersion=1.0-SNAPSHOT \
 -DgroupId=org.example.datecalculator \
 -DartifactId=DateCalculator \
 -Dversion=1.0-SNAPSHOT \
 -DmodelClass=DateParameter \
 -Dname=DateCalculator \
 -Ddescription='Date Calculator' \
 -DrestEndpoint=/api/v1/calculate \
 -DserviceName=DateCalculator \
 -DyourName='Chuck'


