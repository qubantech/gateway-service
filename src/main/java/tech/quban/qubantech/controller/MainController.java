package tech.quban.qubantech.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.quban.qubantech.models.Complaint;

import static tech.quban.qubantech.config.QueueConfig.INCOMING_COMPLAINTS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {
    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/submit")
    ResponseEntity<?> submitComplaint(@RequestBody Complaint complaint) {
        rabbitTemplate.convertAndSend(INCOMING_COMPLAINTS, complaint);
        return ResponseEntity.ok().build();
    }

}
