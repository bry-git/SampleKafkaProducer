FROM gradle:jdk11
COPY . /SampleKafkaProducer
WORKDIR /SampleKafkaProducer

ARG BOOTSTRAP_SERVER
ENV BOOTSTRAP_SERVER=${BOOTSTRAP_SERVER}
ARG KAFKA_TOPIC
ENV KAFKA_TOPIC=${KAFKA_TOPIC}

EXPOSE 8088

