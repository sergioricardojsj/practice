package com.example.exemplos.domain.cliente;

import java.util.List;

public interface BuscarCliente {

    Cliente findById(Long id);

    List<Cliente> findAll();

}
