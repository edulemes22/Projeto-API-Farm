package com.example.api.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

@Entity(name="funcionario")//Classe será mapeada e gerenciada pela JPA
@Table(name="funcionario")//Informa o nome da tabela no banco de dados;
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@NotBlank(message = "Informe o nome")
    private String nome;

    //@NotBlank
    @Size(min = 11, max = 14, message = "Informe o CPF correto")
    private String cpf;

    //@NotBlank(message = "Informe o cargo")
    private String cargo;

    public Long getId() {

        return id;

    }
    public void setId(Long id) {

        this.id = id;

    }
    public String getNome() {

        return nome;

    }
    public void setNome(String nome) {

        this.nome = nome;

    }
    public String getCpf() {

        return cpf;

    }
    public void setCpf(String cpf) {

        this.cpf = cpf;

    }
    public String getCargo() {

        return cargo;

    }
    public void setCargo(String cargo) {

        this.cargo = cargo;

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Funcionario that = (Funcionario) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {

        return Objects.hash(id);

    }
}