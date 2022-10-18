FROM gradle:jdk17
COPY . /SampleKafkaProducer
WORKDIR /SampleKafkaProducer
EXPOSE 8081
