package com.example.api.resource;

import com.example.api.models.Farmacia;
import com.example.api.service.FarmaciaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/farmacia")
public class FarmaciaResource {

    @Autowired
    private FarmaciaService farmaciaService;

    @GetMapping("/listar")
    public List<Farmacia> listar() {

        return farmaciaService.recuperar();

    }


    @GetMapping("/{id}")
    public ResponseEntity<Farmacia> listarPorID(@PathVariable Long id) {

        Farmacia farmaciaSalva = farmaciaService.recuperarPorID(id);


        return ResponseEntity.ok(farmaciaSalva);
    }

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)//Retorna o status criado
    public void adicionar(@Valid @RequestBody Farmacia farmacia, HttpServletResponse response) {

        Farmacia farmaciaSalva = farmaciaService.salvar(farmacia);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")

                .buildAndExpand(farmaciaSalva.getId()).toUri();

        response.setHeader("Location", uri.toASCIIString());

    }

    @DeleteMapping("/{id}/remover")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {

        farmaciaService.excluir(id);

    }

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<Farmacia> atualizar(@PathVariable Long id, @Valid @RequestBody Farmacia farmacia) {

        Farmacia farmaciaSalva = farmaciaService.recuperarPorID(id);

        BeanUtils.copyProperties(farmacia, farmaciaSalva, "id");

        farmaciaService.salvar(farmaciaSalva);

        return ResponseEntity.ok(farmaciaSalva);

    }
}
