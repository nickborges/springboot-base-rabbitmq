package br.com.springboot.base.rabbitmq.feature.controller;


import br.com.springboot.base.rabbitmq.feature.bean.MessageRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Api
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Bad Request: Parâmetro informado é inválido."),
        @ApiResponse(code = 401, message = "Usuário não autenticado."),
        @ApiResponse(code = 403, message = "Usuário sem permissão."),
        @ApiResponse(code = 404, message = "Recurso não encontrado."),
        @ApiResponse(code = 500, message = "Erro interno do servidor."),
        @ApiResponse(code = 503, message = "Erro comunicação gatway."),
        @ApiResponse(code = 504, message = "Serviço inexistente.")
})
interface SenderControllerApi {

    @ApiOperation(value = "Consulta pautas.")
    @ApiResponses({
            @ApiResponse(code = 200,
                    message = "Operação realizada com sucesso.",
                    response = String.class)
    })
    ResponseEntity<String> execute(
            @RequestBody MessageRequest request);
}
