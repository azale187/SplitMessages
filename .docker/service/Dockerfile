FROM harbor.bluestembrands.com/core/openjre:8
ARG VERSION
ARG ARTIFACT_NAME
ARG SPRING_APP_ARGS
COPY files/${ARTIFACT_NAME}-${VERSION}.jar /app/app.jar
CMD /bin/sh -c "java -server -Xms512m -Xmx512m -XX:+UseG1GC -jar /app/app.jar ${SPRING_APP_ARGS}"
