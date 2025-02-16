package ru.otus.java.pro.mt.notifications.transfers.integrations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.otus.java.pro.mt.notifications.dtos.TransferNotification;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "${spring.kafka.topic.transfers-status:}", groupId = "${spring.kafka.consumer.group-id:}")
    public void receiveMessage(TransferNotification message) {
        log.info("По переводу {} клиенту отправлена нотификация", message.getTransferId());
    }

}