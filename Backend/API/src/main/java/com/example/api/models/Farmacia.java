package com.example.api.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

@Entity(name="farmacia")//Classe será mapeada e gerenciada pela JPA
@Table(name="farmacia")//Informa o nome da tabela no banco de dados;
public class Farmacia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@NotBlank(message = "Informe o nome")
    private String nome;

    //@NotBlank
    private String codigo;

    //@NotBlank
    //@Size(min = 14, max = 18, message = "Informe o CNPJ correto")
    private String cnpj;

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

    public String getCodigo() {

        return codigo;

    }

    public void setCodigo(String codigo) {

        this.codigo = codigo;

    }

    public String getCnpj() {

        return cnpj;

    }

    public void setCnpj(String cnpj) {

        this.cnpj = cnpj;

    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Farmacia farmacia = (Farmacia) o;

        return id.equals(farmacia.id);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}