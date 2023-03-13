package com.example.exemplos.application.controllers.cliente.dto;

import com.example.exemplos.domain.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CadastroClienteRequest implements Serializable {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    private String cpf;

    public Cliente toEntity() {
        return new Cliente(0L, nome, cpf);
    }

}
