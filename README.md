# SampleKafkaProducer
example spring boot kafka event producer 

### Building
this requires docker, a zookeeper and kafka instance together, and environment variables that point to zookeeper/kafka 
```
 docker build -t sample-kafka-producer --build-arg BOOTSTRAP_SERVER=127.0.0.1 --build-arg KAFKA_TOPIC=foo .
```
