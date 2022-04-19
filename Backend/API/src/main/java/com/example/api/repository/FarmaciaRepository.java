package com.example.api.repository;

import com.example.api.dao.FarmaciaDao;
import com.example.api.models.Farmacia;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FarmaciaRepository implements FarmaciaDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Farmacia farmacia) {

        em.persist(farmacia);

    }

    @Override
    public List<Farmacia> recuperar() {

        return em.createQuery("select p from farmacia p", Farmacia.class).getResultList();

    }

    @Override
    public Farmacia recuperarPorID(Long id) {

        return em.find(Farmacia.class, id);

    }

    @Override
    public void atualizar(Farmacia farmacia) {

        em.merge(farmacia);

    }

    @Override
    public void excluir(Long id) {

        em.remove(em.getReference(Farmacia.class, id));

    }
}

