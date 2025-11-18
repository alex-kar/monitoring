#!/bin/bash

set -e

mvn clean package -DskipTests -f ../app/pom.xml
java -javaagent:dd-java-agent.jar \
-Dcom.sun.management.jmxremote \
-Dcom.sun.management.jmxremote.port=9010 \
-Dcom.sun.management.jmxremote.rmi.port=9010 \
-Dcom.sun.management.jmxremote.local.only=false \
-Dcom.sun.management.jmxremote.authenticate=false \
-Dcom.sun.management.jmxremote.ssl=false \
-Ddd_trace_debug=true \
-Ddd.agent.host=localhost \
-Ddd.log.level=trace \
-Ddd.jmxfetch.enabled=true \
-jar ../app/target/demo-0.0.1-SNAPSHOT.jar
