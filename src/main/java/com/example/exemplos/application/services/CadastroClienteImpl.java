package com.example.exemplos.application.services;

import com.example.exemplos.application.repositories.ClienteRepository;
import com.example.exemplos.domain.cliente.BuscarCliente;
import com.example.exemplos.domain.cliente.CadastroCliente;
import com.example.exemplos.domain.cliente.Cliente;
import com.example.exemplos.domain.cliente.ValidarCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CadastroClienteImpl implements CadastroCliente {
    private final BuscarCliente buscarCliente;

    private final ClienteRepository clienteRepository;

    private final List<ValidarCliente> validadores;

    public CadastroClienteImpl(BuscarCliente buscarCliente, ClienteRepository clienteRepository, List<ValidarCliente> validadores) {
        this.buscarCliente = buscarCliente;
        this.clienteRepository = clienteRepository;
        this.validadores = validadores;
    }

    @Override
    public Cliente cadastrar(Cliente cliente) {
        Cliente client = buscarCliente.findById(cliente.getId());
        validadores.forEach(v -> v.validar(cliente));

        if (!Objects.isNull(client)) {
            throw new RuntimeException("Cliente já cadastrado!");
        }

        return clienteRepository.save(cliente);
    }

}
