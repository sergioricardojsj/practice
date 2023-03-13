package com.example.exemplos.application.services;

import com.example.exemplos.application.repositories.ClienteRepository;
import com.example.exemplos.domain.cliente.BuscarCliente;
import com.example.exemplos.domain.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarClienteImpl implements BuscarCliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

}
