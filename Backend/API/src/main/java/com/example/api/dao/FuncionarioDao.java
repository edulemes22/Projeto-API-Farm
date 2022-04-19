package com.example.api.dao;

import com.example.api.models.Farmacia;
import com.example.api.models.Funcionario;

import java.util.List;

public interface FuncionarioDao {

    void salvar(Funcionario funcionario);

    List<Funcionario> recuperar();

    Funcionario recuperarPorID(Long id);

    void atualizar(Funcionario funcionario);

    void excluir(Long id);
}
