#!/bin/bash

export LC_ALL=en_US.UTF-8

#tail -f /var/log/lastlog

java -Dspring.profiles.active=local \
-jar /source/util/bin/current_build.jar