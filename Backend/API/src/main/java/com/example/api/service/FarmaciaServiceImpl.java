package com.example.api.service;

import com.example.api.dao.FarmaciaDao;
import com.example.api.models.Farmacia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FarmaciaServiceImpl implements FarmaciaService {

    @Autowired //Injeta uma dependência
    private FarmaciaDao farmaciaDao;

    @Override // reescreve um metodo
    public Farmacia salvar(Farmacia farmacia) {

        farmaciaDao.salvar(farmacia);

        return farmacia;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Farmacia> recuperar() {

        return farmaciaDao.recuperar();

    }

    @Override
    @Transactional(readOnly = true)
    public Farmacia recuperarPorID(Long id) {

        return farmaciaDao.recuperarPorID(id);

    }

    @Override
    public void atualizar(Farmacia farmacia) {

        farmaciaDao.atualizar(farmacia);

    }

    @Override
    public void excluir(Long id) {

        farmaciaDao.excluir(id);

    }

}