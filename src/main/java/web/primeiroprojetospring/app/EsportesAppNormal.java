package web.primeiroprojetospring.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import web.primeiroprojetospring.config.EsportesConfig;
import web.primeiroprojetospring.model.Tecnico;
import web.primeiroprojetospring.service.SorteDiariaArquivoService;
import web.primeiroprojetospring.service.SorteDiariaFelizService;
import web.primeiroprojetospring.service.SorteDiariaRandomicaService;
import web.primeiroprojetospring.service.SorteDiariaService;
import web.primeiroprojetospring.service.SorteDiariaTristeService;

public class EsportesAppNormal {

    public static void main (String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EsportesConfig.class);
        
        // TecnicoBaseball 	→ SorteDiariaTristeService
        // TecnicoPingPong 	→ SorteDiariaFelizService
        // TecnicoTenis 	→ SorteDiariaArquivoService (precisa carregar as sortes do arquivo!)
        // TecnicoNatacao 	→ SorteDiariaRandomicaService
        
        SorteDiariaService feliz = new SorteDiariaFelizService();
        SorteDiariaService triste = new SorteDiariaTristeService();
        SorteDiariaService rand = new SorteDiariaRandomicaService();
        SorteDiariaService arquivo = new SorteDiariaArquivoService();

        Tecnico tecnicos[] = new Tecnico[4];

        tecnicos[0] = context.getBean("xurumela", Tecnico.class);
        tecnicos[1] = context.getBean("tecnicoNatacao", Tecnico.class);
        tecnicos[2] = context.getBean("tecnicoTenis", Tecnico.class);
        tecnicos[3] = context.getBean("tecnicoBaseball", Tecnico.class);

        for (Tecnico t : tecnicos) {
            System.out.println(t.getExercicioDiario());
            System.out.println(t.getSorteDiaria());
        }

        context.close();
    }
}
