package com.example.api.service;

import com.example.api.models.Farmacia;

import java.util.List;

public interface FarmaciaService {

    Farmacia salvar(Farmacia farmacia);

    List<Farmacia> recuperar();

    Farmacia recuperarPorID(Long id);

    void atualizar(Farmacia farmacia);

    void excluir(Long id);
}
