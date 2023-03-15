package web.primeiroprojetospring.app;

import web.primeiroprojetospring.model.Tecnico;
import web.primeiroprojetospring.model.TecnicoNatacao;
import web.primeiroprojetospring.model.TecnicoPingPong;
import web.primeiroprojetospring.service.SorteDiariaFelizService;
import web.primeiroprojetospring.service.SorteDiariaService;

public class EsportesAppNormal {

    public static void main (String[] args) {

        SorteDiariaService sorte = new SorteDiariaFelizService();

        Tecnico tecnico1 = new TecnicoPingPong(sorte);
        TecnicoNatacao tecnico2 = new TecnicoNatacao();
        tecnico2.setSorteDiariaService(sorte);

        System.out.println(tecnico1.getExercicioDiario());
        System.out.println(tecnico1.getSorteDiaria());

        System.out.println(tecnico2.getExercicioDiario());
        System.out.println(tecnico2.getSorteDiaria());
    }
}
