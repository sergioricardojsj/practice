package com.example.exemplos.application.controllers.cliente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CadastroClienteResponse implements Serializable {

    @NotNull
    private Long id;

    @NotNull
    private String nome;
}
