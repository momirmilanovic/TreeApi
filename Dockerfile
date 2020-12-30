FROM openjdk:15

WORKDIR /app

COPY /out/artifacts/TreeApi_jar/TreeApi.jar /app

CMD ["java", "-jar", "TreeApi.jar"]