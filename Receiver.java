@Service
class Receiver {
  
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
  
    @KafkaListener(id = "kafka-batch", topics = "${kafka.topic.app}")
    public void receive(@Payload List<String> messages,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {

        for (int i = 0; i < messages.size(); i++) {
            LOGGER.info("Received message='{}' with partition-offset='{}'", messages.get(i),
                                    partitions.get(i) + "-" + offsets.get(i));
        }
        LOGGER.info("All batch messages received");
    }

}
