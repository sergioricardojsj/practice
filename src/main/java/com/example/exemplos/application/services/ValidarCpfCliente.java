package com.example.exemplos.application.services;

import com.example.exemplos.domain.cliente.Cliente;
import com.example.exemplos.domain.cliente.ValidarCliente;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ValidarCpfCliente implements ValidarCliente {

    @Override
    public void validar(Cliente cliente) {
        if (Objects.isNull(cliente) || cliente.getCpf().length() < 11) {
            throw new RuntimeException("CPF Inválido");
        }
    }

}
