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

    // Mapeando uma variável de ambiente através do spring. Caso não venha nenhum
    // valor, por padrão será assumido o valor "NENHUMA"
    @Value("${ENV_DB_URL:NENHUMA}")
    private String dbEnvironmentVariable;

    // Toda ves que o projeto for aberto no contexto da rota "/", Vamos exibir a
    // mensagem mapeada para desenvolvimento ou para produção
    @GetMapping("/")
    public String getAppMessage() {
        return appMessage;
    }

    // Usado para exibir a variável de ambiente no browser
    @GetMapping("/envVariable")
    public String getEnvironment() {
        return "A seguinte variável de ambiente foi passada: " + dbEnvironmentVariable;
    }

}
