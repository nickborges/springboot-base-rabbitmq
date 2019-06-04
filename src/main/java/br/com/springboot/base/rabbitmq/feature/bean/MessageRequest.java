package br.com.springboot.base.rabbitmq.feature.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MessageRequest {

    @JsonProperty(required = true)
    @NotNull(message = "O atributo resultadoVotacao deve ser informado")
    @NotEmpty(message = "O atributo resultadoVotacao deve ser informado")
    private List<ResultadoVotacao> resultadoVotacao;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
    public static final class ResultadoVotacao {
        @JsonProperty(required = true)
        @NotNull(message = "O atributo idPauta deve ser informado")
        @NotEmpty(message = "O atributo idPauta deve ser informado")
        private String idPauta;

        @JsonProperty(required = true)
        @NotNull(message = "O atributo idSessao deve ser informado")
        @NotEmpty(message = "O atributo idSessao deve ser informado")
        private String idSessao;

        @JsonProperty(required = true)
        @NotNull(message = "O atributo quantidadeVotos deve ser informado")
        private long quantidadeVotos;

        @JsonProperty(required = true)
        @NotNull(message = "O atributo quantidadeVotosSim deve ser informado")
        private long quantidadeVotosSim;

        @JsonProperty(required = true)
        @NotNull(message = "O atributo quantidadeVotosNao deve ser informado")
        private long quantidadeVotosNao;

        @JsonProperty(required = true)
        @NotNull(message = "O atributo resultado deve ser informado")
        @NotEmpty(message = "O atributo resultado deve ser informado")
        private String resultado;
    }
}
