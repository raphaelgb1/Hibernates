package web.primeiroprojetospring.app;

import web.primeiroprojetospring.model.Tecnico;
import web.primeiroprojetospring.model.TecnicoNatacao;
import web.primeiroprojetospring.model.TecnicoPingPong;
import web.primeiroprojetospring.model.TecnicoTenis;
import web.primeiroprojetospring.service.SorteDiariaFelizService;
import web.primeiroprojetospring.service.SorteDiariaService;

public class EsportesAppNormal {

    public static void main (String[] args) {

        SorteDiariaService sorte = new SorteDiariaFelizService();
        Tecnico tecnicos[] = new Tecnico[4];
        tecnicos[0] = new TecnicoPingPong(sorte);
        Tecnico tecnico1 = new TecnicoPingPong(sorte);
        tecnicos[1] = tecnico1;
        tecnicos[2] = new TecnicoTenis(sorte);
        TecnicoNatacao tecnico2 = new TecnicoNatacao();
        tecnico2.setSorteDiariaService(sorte);
        tecnicos[3] = tecnico2;

        for (Tecnico tecnico: tecnicos) {
            System.out.println(tecnico.getExercicioDiario());
            System.out.println(tecnico.getSorteDiaria());
        }
    }
}
