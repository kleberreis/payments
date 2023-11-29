FROM 073521391622.dkr.ecr.us-east-1.amazonaws.com/base_images/alpine:3.12-openjdk13-openj9

WORKDIR /app/build/libs

RUN apk add --no-cache tzdata

ENV TZ America/Sao_Paulo

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
