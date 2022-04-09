package tech.quban.qubantech.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import tech.quban.qubantech.models.Complaint;

import static tech.quban.qubantech.config.QueueConfig.INCOMING_COMPLAINTS;

@Component
@RequiredArgsConstructor
public class MQService {
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = INCOMING_COMPLAINTS)
    private void listener(Complaint complaint) {
        System.out.println("Received msg: " + complaint);
    }

}
