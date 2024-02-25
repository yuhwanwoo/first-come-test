docker exec -it 8f9ecc71f0fb redis-cli

docker exec -it kafka kafka-topics.sh --bootstrap-server localhost:9092 --create --topic coupon_create
docker exec -it kafka kafka-console-producer.sh --topic coupon_create --broker-list 0.0.0.0:9092
docker exec -it kafka kafka-console-consumer.sh --topic coupon_create --bootstrap-server localhost:9092 --key-deserializer "org.apache.kafka.common.serialization.StringDeserializer" --value-deserializer "org.apache.kafka.common.serialization.LongDeserializer"