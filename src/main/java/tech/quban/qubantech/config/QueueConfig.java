package tech.quban.qubantech.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class QueueConfig {
    public static final String INCOMING_COMPLAINTS = "INCOMING_COMPLAINTS";

    private final AmqpAdmin amqpAdmin;

    @PostConstruct
    public void createQueues() {
        amqpAdmin.declareQueue(new Queue(INCOMING_COMPLAINTS, true));
    }
}