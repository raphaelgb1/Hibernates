package web.primeiroprojetospring.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import web.primeiroprojetospring.config.EsportesConfig;
import web.primeiroprojetospring.model.Tecnico;
import web.primeiroprojetospring.model.TecnicoPingPong;

public class EsportesAppSpring {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EsportesConfig.class);
    
        Tecnico tecnico = context.getBean(TecnicoPingPong.class);
    
        System.out.println(tecnico.getExercicioDiario());
        System.out.println(tecnico.getSorteDiaria());
    
        context.close();
    }
}
