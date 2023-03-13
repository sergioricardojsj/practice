package com.example.exemplos.application.services;

import com.example.exemplos.domain.cliente.Cliente;
import com.example.exemplos.domain.cliente.ValidarCliente;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ValidarNomeCliente implements ValidarCliente {

    @Override
    public void validar(Cliente cliente) {
        if (Objects.isNull(cliente) || cliente.getNome().isEmpty()) {
            throw new RuntimeException("Nome inválido");
        }
    }

}
