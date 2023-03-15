package web.primeiroprojetospring.config;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("web.primeiroprojetospring.model")
public class EsportesConfig {
    private static final Logger logger = LoggerFactory.getLogger(EsportesConfig.class);
	
	public EsportesConfig() {
		logger.debug(">> EsportesConfig: dentro do construtor padrão");
	}
}
