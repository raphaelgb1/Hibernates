package web.primeiroprojetospring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import web.primeiroprojetospring.model.Tecnico;
import web.primeiroprojetospring.model.TecnicoNatacao;

@Configuration
@ComponentScan(basePackages = { "web.primeiroprojetospring.model",
        "web.primeiroprojetospring.service" })
public class EsportesConfig {
    private static final Logger logger = LoggerFactory.getLogger(EsportesConfig.class);

    public EsportesConfig() {
        logger.debug(">> EsportesConfig: dentro do construtor padrão");
    }

    @Bean
    public Tecnico tecnicoNatacao() {
        logger.debug(">> EsportesConfig: dentro do método fábrica tecnicoNatacao");
        return new TecnicoNatacao();
    }
}
