package com.dio.exemplospringbootconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Getter;
import lombok.Setter;

// No momento que o projeto começar a rodar, o spring vai identificar que esta
// classe está anotada com @Configuration, vai pegar todos os prefixos nas
// properties iniciados com spring.datadource, juntamente com as propriedades
// devidamente declaradas como variáveis de instância nesta classe, e vai ler o
// arquivo de properties adequado para o profile ativo (dev ou prod);

@Configuration
// Mapeia para a classe todo o grupo de propriedades nos arquivos properties que
// tem o prefixo spring.datasource
@ConfigurationProperties("spring.datadource")
@Getter
@Setter
public class DBConfiguration {

    // Após mapear todas as propriedades com o prefixo spring.datasource, declaramos
    // as propriedades que estão lá, mas em camel case
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    // métodos que fazem o mapeamento das propriedades para dentro do sistema, e
    // sobe ao definir o tipo de profile mais adequado
    @Profile("dev") // Define que este método vai pegar todas as propriedades do ambiente dev
    // Anotamos como um Bean para ver todo o conteúdo sendo mapeado enquanto o
    // sistema sobe
    @Bean
    public String testDatabaseConnection() {
        System.out.println("DB connection for DEV - H2");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB connection to H2_TEST - Test instance";
    }

    @Profile("prod") // Define que este método será mapeado para quando estivermos apontando para o
                     // ambiente prod ao instanciar este bean no momento da execução da configuração
    @Bean
    public String productionDatabaseConnection() {
        System.out.println("DB connection for production - MYSQL");
        System.out.println(driverClassName);
        System.out.println(url);
        return "DB connection to MYSQL_PROD  - Production instance";
    }

}
