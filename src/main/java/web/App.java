package web;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        FiltroLote filtro = new FiltroLote();
        filtro.setCodigo(1L);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vacinacaoPU");
        EntityManager em = emf.createEntityManager();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Lote> criteriaQuery = builder.createQuery(Lote.class);
        Root<Lote> l = criteriaQuery.from(Lote.class);
        TypedQuery<Lote> typedQuery;
        List<Predicate> predicateList = new ArrayList<>();


        Predicate[] predArray = new Predicate[predicateList.size()];
        predicateList.toArray(predArray);

        if (filtro.getCodigo() != null) {
            predicateList.add(builder.equal(l.<String>get("codigo"),
                    filtro.getCodigo()));
        }

        if (filtro.getValidadeInicial() != null) {
            predicateList.add(builder.greaterThanOrEqualTo(
                    l.<LocalDate>get("validade"), filtro.getValidadeInicial()));
        }

        if (filtro.getValidadeFinal() != null) {
            predicateList.add(builder.lessThanOrEqualTo(
                    l.<LocalDate>get("validade"), filtro.getValidadeFinal()));
        }

        if (filtro.getNroDosesDoLoteInicial() != null) {
            predicateList.add(builder.greaterThanOrEqualTo(
                    l.<Integer>get("nroDosesDoLote"), filtro.getNroDosesDoLoteInicial()));
        }
        
        if (filtro.getNroDosesDoLoteFinal() != null) {
            predicateList.add(builder.greaterThanOrEqualTo(
                    l.<Integer>get("nroDosesDoLote"), filtro.getNroDosesDoLoteFinal()));
        }

        if (filtro.getNroDosesAtualInicial() != null) {
            predicateList.add(builder.greaterThanOrEqualTo(
                    l.<Integer>get("nroDosesAtual"), filtro.getNroDosesAtualInicial()));
        }
        
        if (filtro.getNroDosesAtualFinal() != null) {
            predicateList.add(builder.greaterThanOrEqualTo(
                    l.<Integer>get("nroDosesAtual"), filtro.getNroDosesAtualFinal()));
        }

        if (!filtro.getNomeVacina().isBlank()) {
            predicateList.add(builder.like(
                    builder.lower(l.<String>get("vacina")),
                    "%" + filtro.getNomeVacina().toLowerCase() + "%"));
        }


        criteriaQuery.select(l).where(predArray);
        typedQuery = em.createQuery(criteriaQuery);

        List<Lote> lotes = typedQuery.getResultList();

        for (Lote lote : lotes) {
            System.out.println(lote);
            System.out.println(lote.getVacina());
        }

        em.close();
        emf.close();

    }
}
