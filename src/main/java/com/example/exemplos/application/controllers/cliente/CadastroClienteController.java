package com.example.exemplos.application.controllers.cliente;

import com.example.exemplos.application.controllers.cliente.dto.CadastroClienteRequest;
import com.example.exemplos.application.controllers.cliente.dto.CadastroClienteResponse;
import com.example.exemplos.domain.cliente.CadastroCliente;
import com.example.exemplos.domain.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class CadastroClienteController {

    @Autowired
    private CadastroCliente cadastroCliente;

    @PostMapping
    public ResponseEntity<CadastroClienteResponse> cadastrar(@RequestBody @Valid CadastroClienteRequest request) {
        Cliente cliente = request.toEntity();
        cliente = cadastroCliente.cadastrar(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(new CadastroClienteResponse(cliente.getId(), cliente.getNome()));
    }

}
