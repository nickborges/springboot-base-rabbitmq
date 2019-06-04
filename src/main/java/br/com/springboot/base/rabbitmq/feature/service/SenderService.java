package br.com.springboot.base.rabbitmq.feature.service;

import br.com.springboot.base.rabbitmq.feature.bean.MessageRequest;
import br.com.springboot.base.rabbitmq.feature.bean.MessageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    private static final Logger log = LoggerFactory.getLogger(SenderService.class);

    private final RabbitTemplate rabbitTemplate;

    @Value("${queue.exchange}")
    private String exchange_name;

    @Value("${queue.route}")
    private String routing_key;

    public SenderService(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public MessageResponse sendMessage(MessageRequest request) {
        request.getResultadoVotacao().forEach(r -> {
            log.info(">>> Sending message >>> " + request.toString());
            rabbitTemplate.convertAndSend(exchange_name, routing_key, request);
        });
        return build();
    }

    private MessageResponse build(){
        return MessageResponse.builder()
                .message("Menssagem postada com sucesso.")
                .build();
    }
}
