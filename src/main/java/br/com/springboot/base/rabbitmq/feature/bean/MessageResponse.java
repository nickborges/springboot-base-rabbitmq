package br.com.springboot.base.rabbitmq.feature.bean;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MessageResponse {

    private String message;
}
