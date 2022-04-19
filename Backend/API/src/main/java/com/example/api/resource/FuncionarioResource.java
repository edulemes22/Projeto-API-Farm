package com.example.api.resource;

import com.example.api.models.Farmacia;
import com.example.api.models.Funcionario;
import com.example.api.service.FuncionarioService;
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
@RequestMapping("/funcionario")
public class FuncionarioResource {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping("/listar")
    public List<Funcionario> listar() {

        return funcionarioService.recuperar();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> listarPorID(@PathVariable Long id) {

        Funcionario funcionarioSalva = funcionarioService.recuperarPorID(id);

        return ResponseEntity.ok(funcionarioSalva);
    }

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)//Retorna o status criado
    public void adicionar(@Valid @RequestBody Funcionario funcionario, HttpServletResponse response) {

        Funcionario funcionarioSalva = funcionarioService.salvar(funcionario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")

                .buildAndExpand(funcionarioSalva.getId()).toUri();

        response.setHeader("Location", uri.toASCIIString());

    }

    @DeleteMapping("/{id}/remover")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {

        funcionarioService.excluir(id);

    }

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {

        Funcionario funcionarioSalva = funcionarioService.recuperarPorID(id);

        BeanUtils.copyProperties(funcionario, funcionarioSalva, "id");

        funcionarioService.salvar(funcionarioSalva);

        return ResponseEntity.ok(funcionarioSalva);

    }

}
