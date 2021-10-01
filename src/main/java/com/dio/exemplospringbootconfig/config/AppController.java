package com.dio.exemplospringbootconfig.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
classe controller que é responsável pela exibição da propriedade app.message declarada nos
arquivos .properties do environments pro e dev. */
@RestController
public class AppController {

    // Anotação que indica que será injetado todos os valores que comecem com
    // app.message
    @Value("${app.message}")
    private String appMessage;

    // Toda ves que o projeto for aberto no contexto da rota "/", Vamos exibir a
    // mensagem mapeada para desenvolvimento ou para produção
    @GetMapping("/")
    public String getAppMessage() {
        return appMessage;
    }

}
