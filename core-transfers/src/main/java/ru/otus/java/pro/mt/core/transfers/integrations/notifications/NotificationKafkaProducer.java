package ru.otus.java.pro.mt.core.transfers.integrations.notifications;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.otus.java.pro.mt.core.transfers.configs.KafkaConfig;
import ru.otus.java.pro.mt.core.transfers.dtos.TransferNotification;

@Service
@RequiredArgsConstructor
public class NotificationKafkaProducer {

    private final KafkaConfig kafkaConfig;

    private final KafkaTemplate<String, TransferNotification> kafkaTemplate;

    public void sendTransferNotification(TransferNotification notification) {
        kafkaTemplate.send(kafkaConfig.getTransferStatusTopic(), notification);
    }

}