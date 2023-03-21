package web.primeiroprojetospring.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import web.primeiroprojetospring.service.SorteDiariaService;

@Component("xurumela")
public class TecnicoPingPong implements Tecnico {

	private static final Logger logger = LoggerFactory.getLogger(TecnicoPingPong.class);
	
	private SorteDiariaService sorteDiariaService;
	
	// public TecnicoPingPong() {
	// 	logger.debug(">> TecnicoPingPong: dentro do construtor padrão");
	// }
			
	// @Autowired
	@Autowired
	public TecnicoPingPong(@Qualifier("sorteDiariaFelizService") SorteDiariaService sorteDiariaService) {
		logger.debug(">> TecnicoPingPong: dentro do construtor de inicialização");
		this.sorteDiariaService = sorteDiariaService;
	}
	
	public void setSorteDiariaService(SorteDiariaService sorteDiariaService) {
		logger.debug(">> TecnicoPingPong: dentro do setter do SorteDiariaService");
		this.sorteDiariaService = sorteDiariaService;
	}

	@Override
	public String getExercicioDiario() {
		return "Pratique seu saque";
	}

	@Override
	public String getSorteDiaria() {
		return sorteDiariaService.getSorteDiaria();
	}
	
	// @Override
	// public String getSorteDiaria() {
	// 	return "Hoje é seu dia de sorte!";
	// }
}
