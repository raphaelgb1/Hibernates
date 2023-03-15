package web.primeiroprojetospring.app;

import web.primeiroprojetospring.model.Tecnico;
import web.primeiroprojetospring.model.TecnicoPingPong;

public class EsportesAppNormal {

    public static void main (String[] args) {

        Tecnico tecnico1 = new TecnicoPingPong();
        System.out.println(tecnico1.getExercicioDiario());
        System.out.println(tecnico1.getSorteDiaria());
    }
}
