#!/bin/bash
CURDIR=`pwd`
FILE=`echo file://$CURDIR/../target/site/jacoco/index.html`
#echo $FILE
open $FILE
