package com.example.api.dao;

import com.example.api.models.Farmacia;

import java.util.List;

public interface FarmaciaDao {

    void salvar(Farmacia farmacia);

    List<Farmacia> recuperar();

    Farmacia recuperarPorID(Long id);

    void atualizar(Farmacia farmacia);

    void excluir(Long id);
}
