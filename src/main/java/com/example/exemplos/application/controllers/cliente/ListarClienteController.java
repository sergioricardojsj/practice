package com.example.exemplos.application.controllers.cliente;

import com.example.exemplos.application.controllers.cliente.dto.ClienteResponse;
import com.example.exemplos.domain.cliente.BuscarCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ListarClienteController {

    @Autowired
    private BuscarCliente buscarCliente;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> buscarTodos() {
        List<ClienteResponse> response = buscarCliente.findAll()
                .stream()
                .map(cliente -> new ClienteResponse(cliente.getNome(), cliente.getCpf()))
                .toList();

        return ResponseEntity.ok(response);
    }

}
