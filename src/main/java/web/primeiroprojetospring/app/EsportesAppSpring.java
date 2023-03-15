package web.primeiroprojetospring.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import web.primeiroprojetospring.config.EsportesConfig;
import web.primeiroprojetospring.model.Tecnico;
import web.primeiroprojetospring.model.TecnicoPingPong;

public class EsportesAppSpring {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EsportesConfig.class);

        Tecnico tecnico1 = context.getBean(TecnicoPingPong.class);
        Tecnico tecnico2 = context.getBean(TecnicoPingPong.class);

        boolean resultado = tecnico1 == tecnico2;
        System.out.println("Mesmo objeto: " + resultado);
        System.out.println("tecnico1: " + tecnico1);
        System.out.println("tecnico2: " + tecnico2);

        context.close();
    }
}
