package com.example.api.repository;

import com.example.api.dao.FuncionarioDao;
import com.example.api.models.Funcionario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FuncionarioRepository implements FuncionarioDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void salvar(Funcionario funcionario) {

        em.persist(funcionario);

    }

    @Override
    public List<Funcionario> recuperar() {

        return em.createQuery("select p from funcionario p", Funcionario.class).getResultList();

    }

    @Override
    public Funcionario recuperarPorID(Long id) {

        return em.find(Funcionario.class, id);

    }

    @Override
    public void atualizar(Funcionario funcionario) {

        em.merge(funcionario);

    }

    @Override
    public void excluir(Long id) {

        em.remove(em.getReference(Funcionario.class, id));

    }
}
