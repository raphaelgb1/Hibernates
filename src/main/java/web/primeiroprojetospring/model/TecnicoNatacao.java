package web.primeiroprojetospring.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import web.primeiroprojetospring.service.SorteDiariaService;

public class TecnicoNatacao implements Tecnico {

	private static final Logger logger = LoggerFactory.getLogger(TecnicoNatacao.class);
	
	private SorteDiariaService sorteDiariaService;
	
	public TecnicoNatacao() {
		logger.debug(">> TecnicoNatacao: dentro do construtor padrão");
	}
		
	public TecnicoNatacao(@Autowired SorteDiariaService sorteDiariaService) {
		logger.debug(">> TecnicoNatacao: dentro do construtor de inicialização");
		this.sorteDiariaService = sorteDiariaService;
	}

	public void setSorteDiariaService(SorteDiariaService sorteDiariaService) {
		logger.debug(">> TecnicoNatacao: dentro do setter do SorteDiariaService");
		this.sorteDiariaService = sorteDiariaService;
	}
	
	@Override
	public String getExercicioDiario() {
		return "Nade 1000m como aquecimento";
	}

	@Override
	public String getSorteDiaria() {
		return sorteDiariaService.getSorteDiaria();
	}

	
}
