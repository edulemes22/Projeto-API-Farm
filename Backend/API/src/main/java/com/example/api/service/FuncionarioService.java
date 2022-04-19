package com.example.api.service;

import com.example.api.models.Funcionario;

import java.util.List;

public interface FuncionarioService {

    Funcionario salvar(Funcionario funcionario);

    List<Funcionario> recuperar();

    Funcionario recuperarPorID(Long id);

    void atualizar(Funcionario funcionario);

    void excluir(Long id);
}
