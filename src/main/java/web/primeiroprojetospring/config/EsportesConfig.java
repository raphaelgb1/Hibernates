package web.primeiroprojetospring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import web.primeiroprojetospring.model.Tecnico;
import web.primeiroprojetospring.model.TecnicoNatacao;
import web.primeiroprojetospring.service.SorteDiariaService;
import web.primeiroprojetospring.service.SorteDiariaTristeService;

@Configuration
@ComponentScan(basePackages = { "web.primeiroprojetospring.model",
        "web.primeiroprojetospring.service" })
public class EsportesConfig {
    private static final Logger logger = LoggerFactory.getLogger(EsportesConfig.class);

    public EsportesConfig() {
        logger.debug(">> EsportesConfig: dentro do construtor padrão");
    }

    @Bean
    public Tecnico tecnicoNatacao(@Autowired @Qualifier("sorteDiariaRandomicaService") SorteDiariaService sorteDiariaService) {
        logger.debug(">> EsportesConfig: dentro do método fábrica tecnicoNatacao");
        return new TecnicoNatacao(sorteDiariaService);
    }
    @Bean
    public SorteDiariaService sorteDiariaTristeService() {
        logger.debug(">> EsportesConfig: dentro do método fábrica sorteDiariaTristeService");
        return new SorteDiariaTristeService();
    }
}
