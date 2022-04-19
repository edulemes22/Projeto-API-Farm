package com.example.api.service;

import com.example.api.dao.FuncionarioDao;
import com.example.api.models.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FuncionarioServiceImpl implements FuncionarioService {//Long

    @Autowired //Injeta uma dependência
    private FuncionarioDao funcionarioDao;

    @Override
    public Funcionario salvar(Funcionario funcionario) {

        funcionarioDao.salvar(funcionario);

        return funcionario;

    }

    @Override
    @Transactional(readOnly = true)
    public List<Funcionario> recuperar() {

        return funcionarioDao.recuperar();

    }

    @Override
    @Transactional(readOnly = true)
    public Funcionario recuperarPorID(Long id) {

        return funcionarioDao.recuperarPorID(id);

    }

    @Override
    public void atualizar(Funcionario funcionario) {

        funcionarioDao.atualizar(funcionario);

    }

    @Override
    public void excluir(Long id) {

        funcionarioDao.excluir(id);

    }

}