package br.com.springboot.base.rabbitmq.feature.controller;

import br.com.springboot.base.rabbitmq.feature.bean.MessageRequest;
import br.com.springboot.base.rabbitmq.feature.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SenderController implements SenderControllerApi{

    @Autowired
    SenderService service;

    @Override
    @ResponseBody
    @PostMapping("/resultado/votacao")
    public ResponseEntity<String> execute(
            @RequestBody @Validated MessageRequest request){
        return new ResponseEntity(service.sendMessage(request),
                HttpStatus.CREATED);
    }


}
