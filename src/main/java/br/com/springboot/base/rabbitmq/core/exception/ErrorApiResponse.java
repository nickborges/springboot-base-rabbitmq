package br.com.springboot.base.rabbitmq.core.exception;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorApiResponse implements Serializable {

    private String message;

}
