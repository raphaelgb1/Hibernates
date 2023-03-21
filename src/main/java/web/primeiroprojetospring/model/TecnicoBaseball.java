package web.primeiroprojetospring.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import web.primeiroprojetospring.service.SorteDiariaService;

@Component
public class TecnicoBaseball implements Tecnico {

	private static final Logger logger = LoggerFactory.getLogger(TecnicoBaseball.class);

	private SorteDiariaService sorteDiariaService;

	public TecnicoBaseball() {
		logger.debug(">> TecnicoBaseball: dentro do construtor padrão");
	}

	public TecnicoBaseball(SorteDiariaService sorteDiadiaService) {
		logger.debug(">> TecnicoBaseball: dentro do construtor de inicialização");
		this.sorteDiariaService = sorteDiadiaService;
	}

	@Autowired
	public void setSorteDiariaService(SorteDiariaService sorteDiadiaService) {
		logger.debug(">> TecnicoBaseball: dentro do setter do SorteDiariaService");
		this.sorteDiariaService = sorteDiadiaService;
	}

	@Override
	public String getExercicioDiario() {
		return "Pratique 30 minutos de rebatida";
	}

	@Override
	public String getSorteDiaria() {
		return sorteDiariaService.getSorteDiaria();
	}
}
